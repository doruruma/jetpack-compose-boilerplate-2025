package id.andra.jetpackcomposeboilerplate.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import androidx.core.net.toUri
import id.andra.jetpackcomposeboilerplate.R
import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets
import java.util.Calendar
import java.util.UUID

class ComposeFileProvider : FileProvider(R.xml.provider_paths) {
    companion object {
        fun getUri(context: Context, fileType: FileType): Uri {
            val directory = File(context.cacheDir, "media")
            directory.mkdirs()

            val file = File.createTempFile(
                "media_",
                when (fileType) {
                    FileType.IMAGE -> ".jpg"
                    FileType.VIDEO -> ".mp4"
                    FileType.AUDIO -> ".mp3"
                },
                directory
            )

            val authority = context.packageName + ".provider"
            return getUriForFile(
                context,
                authority,
                file
            )
        }

        fun convertUrlToUri(context: Context, fileType: FileType, drawable: Drawable): Uri? {
            val file = try {
                val directory = File(context.cacheDir, "media")
                directory.mkdirs()
                val temp = File.createTempFile(
                    "media_",
                    when (fileType) {
                        FileType.IMAGE -> ".jpg"
                        FileType.VIDEO -> ".mp4"
                        FileType.AUDIO -> ".mp3"
                    },
                    directory
                )
                val outPutStream = FileOutputStream(temp)
                drawable.toBitmap().compress(Bitmap.CompressFormat.JPEG, 100, outPutStream)
                outPutStream.flush()
                outPutStream.close()
                temp
            } catch (e: Throwable) {
                return null
            }
            val authority = context.packageName + ".provider"
            return getUriForFile(
                context,
                authority,
                file
            )
        }

        fun getExistUris(context: Context): List<Uri> {
            val directory = File(context.cacheDir, "media")
            val authority = context.packageName + ".provider"

            if (!directory.exists()) return listOf()

            return directory.listFiles()?.map {
                getUriForFile(
                    context,
                    authority,
                    it
                )
            } ?: listOf()
        }

        private fun deleteCacheFile(context: Context, uri: Uri) {
            context.contentResolver.delete(uri, null, null)
        }

        fun deleteCachePaths(context: Context, paths: List<String>) {
            val cachePaths = paths.filter {
                it.contains(context.packageName + ".provider") &&
                        !it.startsWith("http")
            }
            cachePaths.map {
                deleteCacheFile(context, it.toUri())
            }
        }

        fun calculateUUIDFromFile(file: File): UUID {
            FileInputStream(file).use { fis ->
                val channel = fis.channel
                val buffer =
                    ByteBuffer.allocate(4096) // Adjust the buffer size as per your requirements
                val stringBuilder = StringBuilder()

                while (channel.read(buffer) != -1) {
                    buffer.flip()
                    while (buffer.hasRemaining()) {
                        val b = buffer.get()
                        stringBuilder.append(b.toChar())
                    }
                    buffer.clear()
                }

                val bytes = stringBuilder.toString().toByteArray(StandardCharsets.UTF_8)
                return UUID.nameUUIDFromBytes(bytes)
            }
        }

        fun getStorageFilename(path: String): String {
            val uuid = UUID.nameUUIDFromBytes(path.substringAfterLast("/").toByteArray())
            val date = Calendar.getInstance()
            val month = date.get(Calendar.MONTH).plus(1) //because 0 -> jan
            val day = date.get(Calendar.DAY_OF_MONTH)
            val dateFormat =
                "${date.get(Calendar.YEAR)}/${if (month < 10) "0" else ""}$month/${if (day < 10) "0" else ""}$day"
            return "$dateFormat/$uuid.${path.substringAfterLast(".")}"
        }

        fun getByteArrayFromUri(context: Context, uri: Uri): ByteArray {
            return context.contentResolver.openInputStream(uri)?.use { data ->
                data.buffered().readBytes()
            } ?: byteArrayOf()
        }

        fun getFileFromUri(context: Context, uri: Uri): File? {
            val filePath: String?
            if ("file".equals(uri.scheme, ignoreCase = true)) {
                // File URI scheme
                filePath = uri.path
            } else {
                val inputStream = context.contentResolver.openInputStream(uri)

                val cacheDir = context.cacheDir
                val tempFile = File.createTempFile(
                    uri.path?.substringAfterLast("/").orEmpty(),
                    "",
                    cacheDir
                )

                val outputStream = FileOutputStream(tempFile)
                val buffer = ByteArray(4096)
                var bytesRead: Int

                try {
                    val bufferedInputStream = BufferedInputStream(inputStream)
                    while (bufferedInputStream.read(buffer).also { bytesRead = it } != -1) {
                        outputStream.write(buffer, 0, bytesRead)
                    }
                } catch (e: IOException) {
                    // Handle the exception
                } finally {
                    try {
                        outputStream.close()
                        inputStream?.close()
                    } catch (e: IOException) {
                        // Handle the exception
                    }
                }
                // The contents of the InputStream are now written to the temporary file
                filePath = tempFile.path
            }
            return File(filePath)
        }

        fun getFileFromUri(context: Context, uri: Uri, fileType: FileType): File {
            val directory = File(context.cacheDir, "media")
            directory.mkdirs()
            val file = File.createTempFile(
                "media_",
                when (fileType) {
                    FileType.IMAGE -> ".jpg"
                    FileType.VIDEO -> ".mp4"
                    FileType.AUDIO -> ".mp3"
                },
                directory
            )
            val inputStream = ByteArrayInputStream(getByteArrayFromUri(context, uri))
            inputStream.use { input ->
                file.outputStream().use { output ->
                    input.copyTo(output)
                }
            }
            return file
        }

        fun getSizeImageOfUri(path: String): Pair<Int, Int> { //width, height
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            BitmapFactory.decodeFile(File(path).absolutePath, options)
            return Pair(options.outWidth, options.outHeight)
        }
    }

    enum class FileType {
        IMAGE,
        VIDEO,
        AUDIO
    }
}
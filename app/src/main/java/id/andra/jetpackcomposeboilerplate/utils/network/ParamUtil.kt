package id.andra.jetpackcomposeboilerplate.utils.network

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

object ParamUtil {
    fun createPartFromString(value: String): RequestBody {
        return value.toRequestBody(MultipartBody.FORM)
    }

    fun prepareFilePart(
        partName: String,
        fileName: String,
        fileBytes: List<Byte>,
        mediaType: String = "image/*"
    ): MultipartBody.Part {
        val requestFile = ByteArray(fileBytes.size) { fileBytes[it] }.toRequestBody(
            mediaType.toMediaTypeOrNull()
        )
        return MultipartBody.Part.createFormData(
            name = partName,
            filename = fileName,
            body = requestFile
        )
    }
}
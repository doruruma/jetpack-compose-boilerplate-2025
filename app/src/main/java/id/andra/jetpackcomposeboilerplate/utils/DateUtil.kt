package id.andra.jetpackcomposeboilerplate.utils

import id.andra.jetpackcomposeboilerplate.utils.network.handleThrowable
import timber.log.Timber
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

object DateUtil {
    const val datePattern = "yyyy-MM-dd"
    private const val datePatternDMY = "dd-MM-yyyy"
    private const val dateTimePattern = "yyyy-MM-dd HH:mm"
    private val locale = Locale("id", "ID")

    fun getIndonesianMonth(value: String): String {
        return when (value) {
            "01", "1" -> "Januari"
            "02", "2" -> "Februari"
            "03", "3" -> "Maret"
            "04", "4" -> "April"
            "05", "5" -> "Mei"
            "06", "6" -> "Juni"
            "07", "7" -> "Juli"
            "08", "8" -> "Agustus"
            "09", "9" -> "September"
            "10" -> "Oktober"
            "11" -> "November"
            "12" -> "Desember"
            else -> value
        }
    }

    fun getIndonesianSimpleMonth(value: String): String {
        return when (value) {
            "01", "1" -> "Jan"
            "02", "2" -> "Feb"
            "03", "3" -> "Mar"
            "04", "4" -> "Apr"
            "05", "5" -> "Mei"
            "06", "6" -> "Jun"
            "07", "7" -> "Jul"
            "08", "8" -> "Agt"
            "09", "9" -> "Sep"
            "10" -> "Okt"
            "11" -> "Nov"
            "12" -> "Des"
            else -> value
        }
    }

    fun getIndonesianSimpleDay(value: String): String {
        return when (value) {
            "Mon" -> "Sen"
            "Tue" -> "Sel"
            "Wed" -> "Rab"
            "Thu" -> "Kam"
            "Fri" -> "Jum"
            "Sat" -> "Sab"
            "Sun" -> "Min"
            else -> value
        }
    }

    fun getAllDaysInMonth(calendar: Calendar): List<DayOfMonth> {
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val daysList = mutableListOf<DayOfMonth>()

        val dateFormat = SimpleDateFormat(datePattern, locale)
        val dayFormat = SimpleDateFormat("EEE", locale)

        val month = calendar.get(Calendar.MONTH).plus(1)
        val nameOfMonth = getIndonesianMonth(month.toString())
        val year = calendar.get(Calendar.YEAR)

        for (day in 1..daysInMonth) {
            calendar.set(Calendar.DAY_OF_MONTH, day)
            val date = calendar.time
            daysList.add(
                DayOfMonth(
                    date = calendar,
                    dateFormatted = dateFormat.format(date),
                    name = getIndonesianSimpleDay(dayFormat.format(date)),
                    month = month,
                    year = year,
                    nameOfMonth = nameOfMonth,
                    monthYear = "$nameOfMonth $year"
                )
            )
        }
        Timber.d("dayList ${daysList.size}")
        return daysList
    }

    fun calculateMonth(currentDate: Calendar, isNext: Boolean): Calendar {
        val calendar = Calendar.getInstance()
        calendar.time = currentDate.time
        calendar.add(Calendar.MONTH, if (isNext) 1 else -1)
        Timber.d("calculateMonth ${calendar.get(Calendar.MONTH)}")
        return calendar
    }

    fun getCurrentDaysOfMonth(): List<DayOfMonth> {
        val calendar = Calendar.getInstance()
        return getAllDaysInMonth(calendar)
    }

    fun List<DayOfMonth>.getCurrentDate(): DayOfMonth {
        val calendar = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat(datePattern, locale)
        val dateNow = dateFormat.format(calendar)
        return firstOrNull { it.dateFormatted == dateNow } ?: this[0]
    }

    fun getCurrentDateTime(pattern: String = dateTimePattern): String {
        val date = Date()
        val simpleDateFormat = SimpleDateFormat(pattern, locale)
        return simpleDateFormat.format(date)
    }

    fun getCurrentTimeMillis(): Long {
        return System.currentTimeMillis()
    }

    fun getDateFromMillis(timeMillis: Long, formatPattern: String = "HH:mm"): String {
        if (timeMillis == 0L)
            return ""
        val dateFormat = SimpleDateFormat(formatPattern, locale)
        val date = Date(timeMillis)
        return dateFormat.format(date)
    }

    fun getTimeStampFromYmd(strDate: String): String {
        var date = Date()
        try {
            date = SimpleDateFormat(datePattern, locale).parse(strDate) ?: Date()
        } catch (e: ParseException) {
            e.handleThrowable()
        }
        return "${date.time}"
    }

    fun formatTimeStamp(timeStamp: Long): String {
        if (timeStamp == 0L)
            return ""
        val dateFormat = SimpleDateFormat("dd MMMM yyyy", locale)
        val date = Date(timeStamp)
        return dateFormat.format(date)
    }

    fun getMonthNumber(strDate: String, formatPattern: String = "MMMM yyyy"): String {
        var date = Date()
        try {
            date = SimpleDateFormat(formatPattern, locale).parse(strDate) ?: Date()
        } catch (e: ParseException) {
            e.handleThrowable()
        }
        val simpleDateFormat = SimpleDateFormat("M", locale)
        return simpleDateFormat.format(date)
    }

    fun getMonthName(strDate: String, formatPattern: String = "M"): String {
        var date = Date()
        try {
            date = SimpleDateFormat(formatPattern, locale).parse(strDate) ?: Date()
        } catch (e: ParseException) {
            e.handleThrowable()
        }
        val simpleDateFormat = SimpleDateFormat("MMMM", locale)
        return simpleDateFormat.format(date)
    }

    fun formatYmd(strDate: String): String {
        var date = Date()
        try {
            date = SimpleDateFormat(datePattern, locale).parse(strDate) ?: Date()
        } catch (e: ParseException) {
            e.handleThrowable()
        }
        val simpleDateFormat = SimpleDateFormat("dd MMMM yyyy", locale)
        return simpleDateFormat.format(date)
    }

    fun formatDmy(strDate: String): String {
        var date = Date()
        try {
            date = SimpleDateFormat(datePatternDMY, locale).parse(strDate) ?: Date()
        } catch (e: ParseException) {
            e.handleThrowable()
        }
        val simpleDateFormat = SimpleDateFormat("dd MMMM yyyy", locale)
        return simpleDateFormat.format(date)
    }

    fun formatMonthNameYear(strDate: String): String {
        var date = Date()
        try {
            date = SimpleDateFormat("MMMM yyyy", Locale("en", "US")).parse(strDate) ?: Date()
        } catch (e: ParseException) {
            e.handleThrowable()
        }
        val simpleDateFormat = SimpleDateFormat("MMMM yyyy", locale)
        return simpleDateFormat.format(date)
    }
}

data class DayOfMonth(
    val date: Calendar,
    val dateFormatted: String,
    val name: String,
    val year: Int,
    val month: Int,
    val nameOfMonth: String,
    val monthYear: String
)
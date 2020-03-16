package fr.skyle.peoplover.utils

import android.content.Context
import fr.openium.kotlintools.ext.tryCatchNull
import fr.skyle.peoplover.R
import java.text.SimpleDateFormat
import java.util.*

class DateUtils(context: Context) {

    private var dateAndTime: SimpleDateFormat =
        SimpleDateFormat(context.getString(R.string.date_and_time_format), Locale.getDefault())

    fun format(format: Format, date: Date?): String? =
        tryCatchNull {
            when (format) {
                Format.PRESENTER_DATE_AND_TIME -> date?.let { dateAndTime.format(date) }
            }
        }

    enum class Format {
        PRESENTER_DATE_AND_TIME
    }
}
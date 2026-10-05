package kh.com.mereanandroidyoutube.basictoadvance.util.datetime

import kh.com.mereanandroidyoutube.basictoadvance.util.common.DateFormat
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

object DateTimeUtil {

    fun formatDate(
        date: Long,
        pattern: DateFormat,
        locale: Locale = Locale.getDefault(),
        zone: ZoneId = ZoneId.systemDefault()
    ): String {
        return Instant.ofEpochMilli(date)
            .atZone(zone)
            .format(DateTimeFormatter.ofPattern(pattern.pattern, locale))
    }
}
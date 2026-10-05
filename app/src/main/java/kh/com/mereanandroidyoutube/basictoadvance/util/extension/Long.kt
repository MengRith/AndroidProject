package kh.com.mereanandroidyoutube.basictoadvance.util.extension

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter


fun Long.toDateString(pattern: String): String {
    return Instant.ofEpochMilli(this)
        .atZone(ZoneId.systemDefault())
        .toLocalDate()
        .format(DateTimeFormatter.ofPattern(pattern))
}
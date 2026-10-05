package kh.com.mereanandroidyoutube.basictoadvance.util.common

enum class DateFormat(val pattern: String) {

    // ── ISO / Compact ──
    ISO_DATE("yyyy-MM-dd"),                         // 2026-10-04
    ISO_DATE_TIME("yyyy-MM-dd'T'HH:mm:ss"),         // 2026-10-04T14:30:00
    COMPACT("yyyyMMdd"),                            // 20261004

    // ── Slash ──
    DAY_MONTH_YEAR_SLASH("dd/MM/yyyy"),             // 04/10/2026
    MONTH_DAY_YEAR_SLASH("MM/dd/yyyy"),             // 10/04/2026
    YEAR_MONTH_DAY_SLASH("yyyy/MM/dd"),             // 2026/10/04
    DAY_MONTH_YEAR_SHORT_SLASH("dd/MM/yy"),         // 04/10/26
    MONTH_DAY_YEAR_SHORT_SLASH("MM/dd/yy"),         // 10/04/26

    // ── Dash ──
    DAY_MONTH_YEAR_DASH("dd-MM-yyyy"),              // 04-10-2026
    MONTH_DAY_YEAR_DASH("MM-dd-yyyy"),              // 10-04-2026

    // ── Dot ──
    DAY_MONTH_YEAR_DOT("dd.MM.yyyy"),               // 04.10.2026
    MONTH_DAY_YEAR_DOT("MM.dd.yyyy"),               // 10.04.2026
    YEAR_MONTH_DAY_DOT("yyyy.MM.dd"),               // 2026.10.04

    // ── Month name (text) ──
    DAY_MONTH_SHORT_YEAR("dd MMM yyyy"),            // 04 Oct 2026
    DAY_MONTH_FULL_YEAR("dd MMMM yyyy"),            // 04 October 2026
    MONTH_SHORT_DAY_YEAR("MMM dd, yyyy"),           // Oct 04, 2026
    MONTH_FULL_DAY_YEAR("MMMM dd, yyyy"),           // October 04, 2026
    DAY_MONTH_FULL_SLASH("dd/MMMM/yyyy"),           // 04/October/2026
    MONTH_FULL_DAY_SLASH("MMMM/dd/yyyy"),           // October/04/2026
    MONTH_YEAR("MMMM yyyy"),                        // October 2026
    MONTH_SHORT_YEAR("MMM yyyy"),                   // Oct 2026

    // ── With weekday ──
    WEEKDAY_FULL_DATE("EEEE, dd MMMM yyyy"),        // Sunday, 04 October 2026
    WEEKDAY_SHORT_DATE("EEE, dd MMM yyyy"),         // Sun, 04 Oct 2026

    // ── Date + time ──
    DATE_TIME_24H("dd/MM/yyyy HH:mm"),              // 04/10/2026 14:30
    DATE_TIME_24H_SECONDS("yyyy-MM-dd HH:mm:ss"),   // 2026-10-04 14:30:00
    DATE_TIME_12H("dd/MM/yyyy hh:mm a"),            // 04/10/2026 02:30 PM
    DATE_TIME_MONTH_NAME("dd MMM yyyy, HH:mm"),     // 04 Oct 2026, 14:30

    // ── Time only ──
    TIME_24H("HH:mm"),                              // 14:30
    TIME_24H_SECONDS("HH:mm:ss"),                   // 14:30:00
    TIME_12H("hh:mm a"),                            // 02:30 PM

    // ── Parts only ──
    DAY("dd"),                                      // 04
    MONTH_NUMBER("MM"),                             // 10
    MONTH_NAME_FULL("MMMM"),                        // October
    MONTH_NAME_SHORT("MMM"),                        // Oct
    YEAR("yyyy"),                                   // 2026
    WEEKDAY_FULL("EEEE"),                           // Sunday
    WEEKDAY_SHORT("EEE");                           // Sun
}
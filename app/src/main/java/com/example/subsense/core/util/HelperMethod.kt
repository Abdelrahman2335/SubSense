package com.example.subsense.core.util

import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale


// ===== Long (timestamp) conversions =====

fun Long.toDateString(pattern: String = "MMM dd, yyyy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    return dateFormat.format(Date(this))
}

fun String.toLongDate(pattern: String = "MMM dd, yyyy"): Long {
    val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    return dateFormat.parse(this)?.time ?: 0L
}

// ===== LocalDateTime conversions =====

/**
 * Convert LocalDateTime to formatted String
 * @param pattern DateTimeFormatter pattern (default: "MMM dd, yyyy")
 * Examples: "MMM dd, yyyy" -> "Feb 15, 2026"
 *           "yyyy-MM-dd HH:mm" -> "2026-02-15 14:30"
 */
fun LocalDateTime.toFormattedString(pattern: String = "MMM dd, yyyy"): String {
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    return this.format(formatter)
}

/**
 * Convert String to LocalDateTime
 * @param pattern DateTimeFormatter pattern (default: "MMM dd, yyyy")
 */
fun String.toLocalDateTime(pattern: String = "MMM dd, yyyy"): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    return LocalDateTime.parse(this, formatter)
}

/**
 * Convert LocalDateTime to Long (milliseconds since epoch)
 */
fun LocalDateTime.toEpochMilli(): Long {
    return this.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
}

/**
 * Convert Long (milliseconds) to LocalDateTime
 */
fun Long.toLocalDateTime(): LocalDateTime {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(this), ZoneId.systemDefault())
}

// ===== Combined conversions for convenience =====

/**
 * Convert LocalDateTime to Long and then to formatted String
 */
fun LocalDateTime.toLongTimestamp(): Long {
    return this.toEpochMilli()
}

/**
 * Convert Long timestamp to formatted date String (via LocalDateTime)
 */
fun Long.toLocalDateTimeString(pattern: String = "MMM dd, yyyy"): String {
    return this.toLocalDateTime().toFormattedString(pattern)
}


package com.example.subsense.core.util

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

// ===== LocalDateTime ↔ String =====

fun LocalDateTime.toFormattedString(pattern: String = "MMM dd, yyyy"): String {
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    return this.format(formatter)
}

fun String.toLocalDateTime(pattern: String = "MMM dd, yyyy"): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    return LocalDateTime.parse(this, formatter)
}

// ===== LocalDateTime ↔ Long (timestamp) =====

fun LocalDateTime.toEpochMilli(): Long {
    return this.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
}

fun Long.toLocalDateTime(): LocalDateTime {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(this), ZoneId.systemDefault())
}

// ===== Convenience: Long ↔ String (via LocalDateTime) =====

fun Long.toDateString(pattern: String = "MMM dd, yyyy"): String {
    return this.toLocalDateTime().toFormattedString(pattern)
}

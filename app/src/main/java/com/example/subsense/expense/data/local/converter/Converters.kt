package com.example.subsense.expense.data.local.converter

import androidx.room.TypeConverter
import com.example.subsense.core.data.model.ExpenseCategory
import com.example.subsense.core.util.toEpochMilli
import com.example.subsense.core.util.toLocalDateTime
import com.example.subsense.manage_expences.data.model.RecurringPattern
import kotlinx.serialization.json.Json
import java.time.LocalDateTime

class Converters {

    // Store LocalDateTime as Long (timestamp)
    @TypeConverter
    fun fromLocalDateTime(dateTime: LocalDateTime?): Long? {
        return dateTime?.toEpochMilli()
    }

    @TypeConverter
    fun toLocalDateTime(timestamp: Long?): LocalDateTime? {
        return timestamp?.toLocalDateTime()
    }

    // ExpenseCategory: Store as String ID
    @TypeConverter
    fun fromExpenseCategory(category: ExpenseCategory): String {
        return category.id  // e.g., "food_dining"
    }


    @TypeConverter
    fun toExpenseCategory(id: String): ExpenseCategory {
        return ExpenseCategory.fromId(id) ?: ExpenseCategory.Other
    }

    // RecurringPattern: Store as JSON string
    @TypeConverter
    fun fromRecurringPattern(pattern: RecurringPattern?): String? {
        return pattern?.let { Json.encodeToString(RecurringPattern.serializer(), it) }
    }

    @TypeConverter
    fun toRecurringPattern(json: String?): RecurringPattern? {
        return json?.let { Json.decodeFromString(RecurringPattern.serializer(), it) }
    }
}
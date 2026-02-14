package com.example.subsense.core.data

import androidx.room.TypeConverter
import com.example.subsense.core.model.ExpenseCategory
import com.example.subsense.setting.data.model.RecurringPattern
import kotlinx.serialization.json.Json

class Converters {

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
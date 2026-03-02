package com.example.subsense.debts.data.local.converter

import androidx.room.TypeConverter
import com.example.subsense.debts.data.model.DebtType

class DebtConverters {

    @TypeConverter
    fun fromDebtType(value: DebtType): String = value.name

    @TypeConverter
    fun toDebtType(value: String): DebtType = DebtType.valueOf(value)
}
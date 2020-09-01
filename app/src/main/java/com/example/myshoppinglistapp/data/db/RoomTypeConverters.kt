package com.example.myshoppinglistapp.data.db

import androidx.room.TypeConverter
import java.time.LocalDate

class RoomTypeConverters {

    @TypeConverter
    fun fromEpochDays(value: Long?): LocalDate? = value?.let { LocalDate.ofEpochDay(it) }

    @TypeConverter
    fun dateToEpochDays(date: LocalDate?): Long? = date?.toEpochDay()
}
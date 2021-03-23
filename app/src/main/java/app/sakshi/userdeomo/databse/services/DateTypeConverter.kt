package app.sakshi.userdeomo.databse.services

import androidx.room.TypeConverter
import java.util.*

/**
 *Created by Dipan Papaiya on 23-June-2020.
 **/
class DateTypeConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}
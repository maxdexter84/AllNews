package ru.maxdexter.allnews.data.localsource.database

import androidx.room.TypeConverter
import ru.maxdexter.allnews.data.remotesource.model.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(str: String): Source {
        return Source(str, str)
    }
}
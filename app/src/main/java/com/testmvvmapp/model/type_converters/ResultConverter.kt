package com.testmvvmapp.model.type_converters

import androidx.room.*
import com.google.gson.reflect.TypeToken
import com.testmvvmapp.model.entities.MainInfo
import com.testmvvmapp.model.type_converters.parser.JsonParser

@ProvidedTypeConverter
class ResultConverter(private val jsonParser: JsonParser) {
    @TypeConverter
    fun fromMainInfoJson(json: String): List<MainInfo> = jsonParser.fromJson<ArrayList<MainInfo>>(json, object : TypeToken<ArrayList<MainInfo>>() {}.type) ?: emptyList()
    @TypeConverter
    fun toMainInfoJson(json: List<MainInfo>): String = jsonParser.toJson(json, object : TypeToken<ArrayList<MainInfo>>() {}.type) ?: "[]"
}
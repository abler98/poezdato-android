package net.poezdato.android.domain.retrofit.converter

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.TypeAdapter
import com.google.gson.reflect.TypeToken
import net.poezdato.android.domain.retrofit.type.JsonParam
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 24.09.2018.
 */

class JsonParameterConverterFactory(private val gson: Gson) : Converter.Factory() {

    override fun stringConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<*, String>? {
        for (annotation in annotations) {
            if (annotation is JsonParam) {
                val adapter = gson.getAdapter(TypeToken.get(type))
                return JsonParameterStringConverter(adapter, annotation.path)
            }
        }
        return super.stringConverter(type, annotations, retrofit)
    }

    class JsonParameterStringConverter<T>(
        private val adapter: TypeAdapter<T>,
        private val path: String
    ) : Converter<T, String> {

        private val segments = path.split(".")

        override fun convert(value: T): String {
            val json = adapter.toJsonTree(value)
            return getValueByPath(json, 0)
        }

        private fun getValueByPath(json: JsonElement, index: Int): String {
            lateinit var element: JsonElement
            if (json.isJsonObject) {
                element = json.asJsonObject.get(segments[index])
            } else {
                throw IllegalArgumentException("Object does not contains $path")
            }
            if (index >= (segments.size - 1)) {
                if (element.isJsonPrimitive) {
                    return element.asString
                } else {
                    throw IllegalArgumentException("Value at $path must be primitive")
                }
            } else {
                return getValueByPath(element, index + 1)
            }
        }

    }

}

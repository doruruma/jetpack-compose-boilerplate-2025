package id.andra.jetpackcomposeboilerplate.utils.extension

import org.json.JSONArray
import org.json.JSONObject

fun JSONObject.toMap(): Map<String, Any?> =
    keys().asSequence().associateWith { key -> toValue(get(key)) }

fun JSONArray.toList(): List<Any?> =
    (0 until length()).map { index -> toValue(get(index)) }

private fun toValue(element: Any) = when (element) {
    JSONObject.NULL -> null
    is JSONObject -> element.toMap()
    is JSONArray -> element.toList()
    else -> element
}
package weather

import com.nowtv.domain.common.BaseMapperToDomain
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonElement
import weather.entitiy.DayWeather

class JsonElementToDayWeatherConverter : BaseMapperToDomain<JsonElement, DayWeather>() {

    private val json = Json(JsonConfiguration.Stable)

    override fun mapToDomain(toBeTransformed: JsonElement): DayWeather {
        val jsonStr = toBeTransformed.toString()
        val dayWeatherData = json.parse(DayWeatherData.serializer(), jsonStr )
        return DayWeather(
            dayId = dayWeatherData.day?.toInt() ?: 0,
            weatherCondition = dayWeatherData.description,
            weatherConditionImageUrl = dayWeatherData.image,
            minTemperature = dayWeatherData.low,
            maxTemperature = dayWeatherData.high,
            chancesOfRainPercent = dayWeatherData.chance_rain?.times(100)
        )
    }

    @Serializable
    private data class DayWeatherData (
        val day: String? = null,
        val description: String? = null,
        val sunrise: Int? = null,
        val sunset: Int? = null,
        val chance_rain: Double? = null,
        val high: Int? = null,
        val low: Int? = null,
        val image: String? = null
    )
}
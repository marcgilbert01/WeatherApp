package weather.entitiy

data class DayWeather (
    val dayId: Int,
    val weatherCondition: String? = null,
    val weatherConditionImageUrl: String? = null
)
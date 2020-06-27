package WeatheList

import com.nowtv.domain.common.BaseMapperToPresentation
import weather.entitiy.DayWeather

class DayWeatherToWeatherListItemUiModelConverter : BaseMapperToPresentation<DayWeather, WeatherListItemUiModel>() {
    override fun mapToPresentation(toBeTransformed: DayWeather): WeatherListItemUiModel {
        return WeatherListItemUiModel(
            title = toBeTransformed.weatherCondition,
            imageUrl = toBeTransformed.weatherConditionImageUrl,
            maxTemperature = toBeTransformed.maxTemperature.toString()
        )
    }
}
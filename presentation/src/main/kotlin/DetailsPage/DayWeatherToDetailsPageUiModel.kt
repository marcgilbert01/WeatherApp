package DetailsPage

import com.nowtv.domain.common.BaseMapperToPresentation
import weather.entitiy.DayWeather

class DayWeatherToDetailsPageUiModel : BaseMapperToPresentation<DayWeather, DetailsPageUiModel>() {

    override fun mapToPresentation(toBeTransformed: DayWeather): DetailsPageUiModel {
        return DetailsPageUiModel(
            title = toBeTransformed.weatherCondition,
            imageUrl = toBeTransformed.weatherConditionImageUrl
        )
    }
}
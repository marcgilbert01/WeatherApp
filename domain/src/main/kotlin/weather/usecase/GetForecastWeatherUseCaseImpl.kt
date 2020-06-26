package weather.usecase

import io.reactivex.Single
import weather.entitiy.DayWeather

class GetForecastWeatherUseCaseImpl : GetForecastWeatherUseCase {

    override fun buildUseCase(): Single<List<DayWeather>> {
        val tmpMocks = listOf<DayWeather>(
            DayWeather("sunny", ""),
            DayWeather("cloudy", ""),
            DayWeather("snowy", ""),
            DayWeather("rainy", ""),
            DayWeather("hot", ""),
            DayWeather("cold", ""),
            DayWeather("horrible", "")
        )

        return Single.just(tmpMocks)
    }
}
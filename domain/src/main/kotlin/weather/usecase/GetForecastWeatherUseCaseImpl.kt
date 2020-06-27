package weather.usecase

import io.reactivex.Single
import weather.entitiy.DayWeather
import weather.repository.WeatherForecastRepository

class GetForecastWeatherUseCaseImpl(
    private val weatherForecastRepository: WeatherForecastRepository
) : GetForecastWeatherUseCase {

    override fun buildUseCase(): Single<List<DayWeather>> {
        return weatherForecastRepository.getWeatherForecast()
    }
}
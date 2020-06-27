package weather.usecase

import io.reactivex.Single
import weather.entitiy.DayWeather
import weather.repository.WeatherForecastRepository

class GetForecastWeatherUseCaseImpl(
    private val weatherForecastRepository: WeatherForecastRepository
) : GetForecastWeatherUseCase {

    override fun buildUseCase(params: GetForecastWeatherUseCase.Params): Single<List<DayWeather>> {
        return weatherForecastRepository.getWeatherForecast()
            .map {
                if (params.shouldSortByHottestDay) {
                    filterAndorderByHottestDays(it)
                } else {
                    it
                }
            }
    }

    private fun filterAndorderByHottestDays(allDays: List<DayWeather>): List<DayWeather> {
        val hottestDay = ArrayList<DayWeather>()
        for (day in allDays) {
            day.chancesOfRainPercent?.let {
                if (it < 50) {
                    hottestDay.add(day)
                }
            }
        }
        hottestDay.sortBy {
            it.maxTemperature
        }
        return hottestDay
    }
}
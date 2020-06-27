package weather.usecase

import io.reactivex.Single
import weather.entitiy.DayWeather
import weather.repository.WeatherForecastRepository

class GetForecastWeatherUseCaseImpl(
    private val weatherForecastRepository: WeatherForecastRepository
) : GetForecastWeatherUseCase {

    companion object {
        var cachedWeatherData: List<DayWeather>? = null
    }

    override fun buildUseCase(params: GetForecastWeatherUseCase.Params): Single<List<DayWeather>> {
        return weatherForecastRepository.getWeatherForecast()
            .onErrorReturn {
                cachedWeatherData ?: ArrayList()
            }
            .map {
                cachedWeatherData = it
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
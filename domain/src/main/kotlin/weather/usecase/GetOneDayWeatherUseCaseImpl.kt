package weather.usecase

import io.reactivex.Single
import weather.entitiy.DayWeather

class GetOneDayWeatherUseCaseImpl(
    private val getForecastWeatherUseCase: GetForecastWeatherUseCase
) : GetOneDayWeatherUseCase {

    override fun buildUseCase(params: GetOneDayWeatherUseCase.Params): Single<DayWeather> {
        return getForecastWeatherUseCase.buildUseCase()
            .map {
                findDayFrom(params.dayId, it) ?: DayWeather(0)
            }
    }

    private fun findDayFrom(dayId: Int, dayWeatherList: List<DayWeather>): DayWeather? {
        for (dayWeather in dayWeatherList) {
            if (dayId == dayWeather.dayId) {
                return dayWeather
            }
        }
        return null
    }
}
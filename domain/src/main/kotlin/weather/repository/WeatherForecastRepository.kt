package weather.repository

import io.reactivex.Single
import weather.entitiy.DayWeather

interface WeatherForecastRepository {

    fun getWeatherForecast(): Single<List<DayWeather>>
}
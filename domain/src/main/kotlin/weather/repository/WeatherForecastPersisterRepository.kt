package weather.repository

import io.reactivex.Completable
import io.reactivex.Single
import weather.entitiy.DayWeather

interface WeatherForecastPersisterRepository {

    fun saveWeatherForecast(weatherForecastList: List<DayWeather>): Completable

    fun retrieveSavedWeatherForecast(): Single<RetrievedWeatherForecast>

    data class RetrievedWeatherForecast (val weatherForecastList: List<DayWeather>, val timeSaved: Long)
}
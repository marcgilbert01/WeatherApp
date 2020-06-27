package weather

import com.nowtv.domain.common.BaseMapperToDomain
import io.reactivex.Single
import weather.entitiy.DayWeather
import weather.repository.WeatherForecastRepository
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.lang.Exception

class WeatherForecastRepositoryImpl(
    private val jsonObjectToDayWeatherConverter: BaseMapperToDomain<JsonElement, DayWeather>
) : WeatherForecastRepository {

    private val json = Json(JsonConfiguration.Stable)

    @ImplicitReflectionSerializer
    override fun getWeatherForecast(): Single<List<DayWeather>> {
        return Single.fromCallable {
            var dayWeatherList: List<DayWeather>
            val connection = URL("https://5c5c8ba58d018a0014aa1b24.mockapi.io/api/forecast").openConnection() as HttpURLConnection
            if (connection.responseCode != 200) {
                throw CantAccessApiException()
            }
            connection.inputStream.bufferedReader().readText().let {
                val jsonElement = json.parseJson(it)
                jsonElement.jsonArray.content.toList().let {
                    dayWeatherList = jsonObjectToDayWeatherConverter.mapToDomain(it)
                }
            }
            dayWeatherList
        }
    }

    class CantAccessApiException: Exception()
}
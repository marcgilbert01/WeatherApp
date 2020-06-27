package weather.usecase

import com.nowtv.domain.common.UseCase
import com.nowtv.domain.common.UseCaseVoid
import io.reactivex.Single
import weather.entitiy.DayWeather

interface GetForecastWeatherUseCase : UseCase<Single<List<DayWeather>>, GetForecastWeatherUseCase.Params> {

    override fun buildUseCase(params: Params): Single<List<DayWeather>>

    data class Params(val shouldSortByHottestDay: Boolean = false)
}
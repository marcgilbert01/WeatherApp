package weather.usecase

import com.nowtv.domain.common.UseCase
import io.reactivex.Single
import weather.entitiy.DayWeather

interface GetOneDayWeatherUseCase : UseCase<Single<DayWeather>, GetOneDayWeatherUseCase.Params> {

    override fun buildUseCase(params: Params): Single<DayWeather>

    data class Params(val dayId: Int)
}
package weather.usecase

import com.nowtv.domain.common.UseCaseVoid
import io.reactivex.Single
import weather.entitiy.DayWeather

interface GetForecastWeatherUseCase : UseCaseVoid<Single<List<DayWeather>>> {

    override fun buildUseCase(): Single<List<DayWeather>>
}
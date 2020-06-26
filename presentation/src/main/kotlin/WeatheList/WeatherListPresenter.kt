package WeatheList

import Rx.uiScheduler
import com.nowtv.domain.common.BaseMapperToPresentation
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import weather.entitiy.DayWeather
import weather.usecase.GetForecastWeatherUseCase

class WeatherListPresenter(
    private val view: WeatherListContract.View,
    private val getForecastWeatherUseCase: GetForecastWeatherUseCase,
    private val dayWeatherToWeatherListItemUiModelConverter: BaseMapperToPresentation<DayWeather, WeatherListItemUiModel>
) : WeatherListContract.Presenter {

    private val compositeDisposable = CompositeDisposable()
    private var isListDisplayed = false

    override fun onViewStart() {
        if (!isListDisplayed) {
            compositeDisposable.add(
                getForecastWeatherUseCase.buildUseCase()
                    .subscribeOn(Schedulers.io())
                    .observeOn(uiScheduler)
                    .subscribe({
                        view.displayWeatherList(dayWeatherToWeatherListItemUiModelConverter.mapToPresentation(it))
                        isListDisplayed = true
                    },{
                        print(it)
                    })
            )
        }
    }

    override fun onViewStop() {
        compositeDisposable.clear()
    }
}
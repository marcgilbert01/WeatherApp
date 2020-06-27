package WeatheList

import Navigators.AppNavigator
import Rx.uiScheduler
import com.nowtv.domain.common.BaseMapperToPresentation
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import weather.entitiy.DayWeather
import weather.usecase.GetForecastWeatherUseCase

class WeatherListPresenter(
    private val view: WeatherListContract.View,
    private val getForecastWeatherUseCase: GetForecastWeatherUseCase,
    private val dayWeatherToWeatherListItemUiModelConverter: BaseMapperToPresentation<DayWeather, WeatherListItemUiModel>,
    private val appNavigator: AppNavigator
) : WeatherListContract.Presenter {

    private val compositeDisposable = CompositeDisposable()
    private var isListDisplayed = false
    private var dayWeatherList: List<DayWeather>? = null

    override fun onViewStart() {
        if (!isListDisplayed) {
            compositeDisposable.add(
                getForecastWeatherUseCase.buildUseCase()
                    .subscribeOn(Schedulers.io())
                    .observeOn(uiScheduler)
                    .subscribe({
                        dayWeatherList = it
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

    override fun onWeatherDayClicked(positionInTheList: Int) {
        dayWeatherList?.get(positionInTheList)?.let {
            appNavigator.navigateToWeatherDayDetailsPage(it.dayId)
        }
    }
}
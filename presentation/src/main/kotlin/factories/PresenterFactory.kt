package factories

import WeatheList.DayWeatherToWeatherListItemUiModelConverter
import WeatheList.WeatherListContract
import WeatheList.WeatherListPresenter
import weather.usecase.GetForecastWeatherUseCaseImpl

class PresenterFactory {

    fun createWeatherListPresenterForUpcomingWeather(
        view: WeatherListContract.View
    ): WeatherListContract.Presenter {
        return WeatherListPresenter(
            view = view,
            getForecastWeatherUseCase = GetForecastWeatherUseCaseImpl(),
            dayWeatherToWeatherListItemUiModelConverter = DayWeatherToWeatherListItemUiModelConverter()
        )
    }
}
package factories

import Navigators.appNavigator
import WeatheList.DayWeatherToWeatherListItemUiModelConverter
import WeatheList.WeatherListContract
import WeatheList.WeatherListPresenter
import weather.JsonObjectToDayWeatherConverter
import weather.WeatherForecastRepositoryImpl
import weather.usecase.GetForecastWeatherUseCaseImpl

class PresenterFactory {

    fun createWeatherListPresenterForUpcomingWeather(
        view: WeatherListContract.View
    ): WeatherListContract.Presenter {
        return WeatherListPresenter(
            view = view,
            getForecastWeatherUseCase = GetForecastWeatherUseCaseImpl(
                WeatherForecastRepositoryImpl(
                    JsonObjectToDayWeatherConverter()
                )
            ),
            dayWeatherToWeatherListItemUiModelConverter = DayWeatherToWeatherListItemUiModelConverter(),
            appNavigator = appNavigator
        )
    }
}
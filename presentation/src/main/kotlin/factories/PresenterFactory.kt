package factories

import DetailsPage.DayWeatherToDetailsPageUiModel
import DetailsPage.DetailsPageContract
import DetailsPage.DetailsPagePresenter
import Navigators.appNavigator
import WeatheList.DayWeatherToWeatherListItemUiModelConverter
import WeatheList.WeatherListContract
import WeatheList.WeatherListPresenter
import weather.JsonObjectToDayWeatherConverter
import weather.WeatherForecastRepositoryImpl
import weather.usecase.GetForecastWeatherUseCaseImpl
import weather.usecase.GetOneDayWeatherUseCaseImpl

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
            shouldOrderByHottestDay = false,
            dayWeatherToWeatherListItemUiModelConverter = DayWeatherToWeatherListItemUiModelConverter(),
            appNavigator = appNavigator
        )
    }

    fun createWeatherListPresenterForHottestDay(
        view: WeatherListContract.View
    ): WeatherListContract.Presenter {
        return WeatherListPresenter(
            view = view,
            getForecastWeatherUseCase = GetForecastWeatherUseCaseImpl(
                WeatherForecastRepositoryImpl(
                    JsonObjectToDayWeatherConverter()
                )
            ),
            shouldOrderByHottestDay = true,
            dayWeatherToWeatherListItemUiModelConverter = DayWeatherToWeatherListItemUiModelConverter(),
            appNavigator = appNavigator
        )
    }

    fun createWeatherDetailsPageForOneDay(
        view: DetailsPageContract.View,
        dayId: Int
    ): DetailsPageContract.Presenter {
        return DetailsPagePresenter(
            view = view,
            getOneDayWeatherUseCase = GetOneDayWeatherUseCaseImpl(
                GetForecastWeatherUseCaseImpl(
                    WeatherForecastRepositoryImpl(
                        JsonObjectToDayWeatherConverter()
                    )
                )
            ),
            dayWeatherToWeatherListItemUiModelConverter = DayWeatherToDetailsPageUiModel(),
            dayId = dayId
        )
    }
}
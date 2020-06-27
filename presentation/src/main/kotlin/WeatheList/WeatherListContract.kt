package WeatheList

interface WeatherListContract {

    interface View {
        fun displayWeatherList(weatherListItemUiModel: List<WeatherListItemUiModel>)
    }

    interface Presenter {
        fun onViewStart()
        fun onViewStop()
        fun onWeatherDayClicked(positionInTheList: Int)
    }
}
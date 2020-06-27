package Navigators

interface AppNavigator {

    fun navigateToWeatherDayDetailsPage(dayId: Int)

}

lateinit var appNavigator: AppNavigator
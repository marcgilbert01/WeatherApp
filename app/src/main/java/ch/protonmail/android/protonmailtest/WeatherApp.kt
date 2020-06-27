package ch.protonmail.android.protonmailtest

import Navigators.AppNavigator
import Navigators.appNavigator
import Rx.uiScheduler
import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import factories.PresenterFactory
import io.reactivex.android.schedulers.AndroidSchedulers

class WeatherApp : Application() {

    companion object {
        val presenterFactory = PresenterFactory()
    }

    private var lastCreatedActivity: Activity? = null

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(AppActivityLifecycleCallbacks())
        uiScheduler = AndroidSchedulers.mainThread()
        appNavigator = object : AppNavigator {
            override fun navigateToWeatherDayDetailsPage(dayId: Int) {
                lastCreatedActivity?.let { currentActivity ->
                    val intent = Intent(currentActivity, DetailsActivity::class.java)
                    intent.putExtra(DetailsActivity.PARAM_DAY_ID, dayId)
                    currentActivity.startActivity(intent)
                }
            }
        }
    }

    inner class AppActivityLifecycleCallbacks : ActivityLifecycleCallbacks {
        override fun onActivityPaused(p0: Activity?) {
        }

        override fun onActivityResumed(p0: Activity?) {
        }

        override fun onActivityStarted(p0: Activity?) {
        }

        override fun onActivityDestroyed(p0: Activity?) {
        }

        override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
        }

        override fun onActivityStopped(p0: Activity?) {
        }

        override fun onActivityCreated(p0: Activity?, p1: Bundle?) {
            lastCreatedActivity = p0
        }
    }
}
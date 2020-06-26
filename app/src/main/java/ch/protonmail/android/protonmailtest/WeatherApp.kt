package ch.protonmail.android.protonmailtest

import Rx.uiScheduler
import android.app.Application
import factories.PresenterFactory
import io.reactivex.android.schedulers.AndroidSchedulers

class WeatherApp : Application() {

    companion object {
        val presenterFactory = PresenterFactory()
    }

    override fun onCreate() {
        super.onCreate()
        uiScheduler = AndroidSchedulers.mainThread()
    }
}
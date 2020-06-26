package ch.protonmail.android.protonmailtest

import WeatheList.WeatherListContract
import WeatheList.WeatherListItemUiModel
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by ProtonMail on 2/25/19.
 * Shows the upcoming list of days returned by the API in order of day
 **/
class UpcomingFragment : Fragment(), WeatherListContract.View {

    private var adapter: ForecastAdapter? = null
    private var presenter: WeatherListContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = WeatherApp.presenterFactory.createWeatherListPresenterForUpcomingWeather(this)
    }

    // TODO: Please fix any errors and implement the missing parts (including any UI changes)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_hottest, container, false)

        val layoutManager = LinearLayoutManager(context)
        adapter = ForecastAdapter()
        //adapter?.updateData(arrayOf("one", "two", "three", "four"))
        val recycler = rootView.findViewById<RecyclerView>(R.id.recycler_view)
        recycler.adapter = adapter
        recycler.layoutManager = layoutManager

        rootView.setBackgroundColor(Color.RED)
        return rootView
    }

    override fun onStart() {
        super.onStart()
        presenter?.onViewStart()
    }

    override fun onStop() {
        super.onStop()
        presenter?.onViewStop()
    }

    override fun displayWeatherList(weatherListItemUiModel: List<WeatherListItemUiModel>) {
        adapter?.updateData(weatherListItemUiModel)
    }

    //
//    fun fetchData() {
//        if (dataPresentInLocalStorage()) {
//            fetchDataFromLocalStorage()
//        } else {
//            fetchDataFromServer()
//        }
//    }
//
//    fun fetchDataFromServer() {
//        FetchDataFromServerTask().execute()
//    }
//
//    fun fetchDataFromLocalStorage(): Array<String>? {
//        // TODO implement
//        return null
//    }
//
//    fun dataPresentInLocalStorage(): Boolean = false
//
//    class FetchDataFromServerTask : AsyncTask<String, String, String>() {
//        override fun doInBackground(vararg p0: String?): String {
//            val url = URL("https://5c5c8ba58d018a0014aa1b24.mockapi.io/api/forecast")
//            val httpURLConnection = url.openConnection() as HttpURLConnection
//            httpURLConnection.connect()
//
//            val responseCode: Int = httpURLConnection.responseCode
//
//            var response: String = ""
//            if (responseCode == 200) {
//                response = httpURLConnection.responseMessage
//            }
//            return response
//        }
//
//        override fun onPostExecute(result: String?) {
//            super.onPostExecute(result)
//
//        }
//    }
}
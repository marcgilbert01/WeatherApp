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
 * Shows any days that have less than a 50% chance of rain, ordered hottest to coldest
 * */
class HottestFragment : Fragment(), WeatherListContract.View {

    private var adapter: ForecastAdapter? = null
    private var presenter: WeatherListContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = WeatherApp.presenterFactory.createWeatherListPresenterForHottestDay(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_hottest, container, false)

        val layoutManager = LinearLayoutManager(context)
        adapter = ForecastAdapter()
        adapter?.setOnItemClickedListener { positionInTheList ->
            presenter?.onWeatherDayClicked(positionInTheList)
        }
        val recycler = rootView.findViewById<RecyclerView>(R.id.recycler_view)
        recycler.adapter = adapter
        recycler.layoutManager = layoutManager

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
}
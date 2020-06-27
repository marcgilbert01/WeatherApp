package ch.protonmail.android.protonmailtest

import DetailsPage.DetailsPageContract
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_details.*

/**
 * Created by ProtonMail on 2/25/19.
 * Shows all the details for a particular day.
 */
class DetailsActivity : AppCompatActivity(), DetailsPageContract.View {

    companion object {
        const val PARAM_DAY_ID = "PARAM_DAY_ID"
    }

    private var presenter: DetailsPageContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        presenter = WeatherApp.presenterFactory.createWeatherDetailsPageForOneDay(
                    this,
                    intent.getIntExtra(PARAM_DAY_ID, 0))
        download_button.setOnClickListener {
            presenter?.onDownloadButtonPress()
        }
    }

    override fun onStart() {
        super.onStart()
        presenter?.onViewStart()
    }

    override fun onStop() {
        super.onStop()
        presenter?.onViewStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onViewDestroy()
    }

    override fun showTitle(title: String) {
        title_text?.text = title
    }

    override fun showImage(imageUrl: String) {
        image.setUrl(imageUrl)
        download_button.visibility = View.GONE
    }

    override fun showTemperatures(temperatures: String) {
        temperatures_text?.text = temperatures
    }

    override fun showChancesOfRain(chancesOfRain: String) {
        chance_of_rain_text?.text = chancesOfRain
    }
}

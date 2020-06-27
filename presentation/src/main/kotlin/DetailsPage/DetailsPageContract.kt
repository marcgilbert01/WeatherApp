package DetailsPage

interface DetailsPageContract {

    interface View {
        fun showTitle(title: String)
        fun showImage(imageUrl: String)
        fun showTemperatures(temperatures: String)
        fun showChancesOfRain(chancesOfRain: String)
    }

    interface Presenter {
        fun onViewStart()
        fun onViewStop()
        fun onViewDestroy()
        fun onDownloadButtonPress()
    }
}
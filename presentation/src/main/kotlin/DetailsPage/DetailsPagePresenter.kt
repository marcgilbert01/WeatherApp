package DetailsPage

import Rx.uiScheduler
import com.nowtv.domain.common.BaseMapperToPresentation
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import weather.entitiy.DayWeather
import weather.usecase.GetOneDayWeatherUseCase

class DetailsPagePresenter(
    private val view: DetailsPageContract.View,
    private val getOneDayWeatherUseCase: GetOneDayWeatherUseCase,
    private val dayWeatherToWeatherListItemUiModelConverter: BaseMapperToPresentation<DayWeather, DetailsPageUiModel>,
    private val dayId: Int
) : DetailsPageContract.Presenter {

    private val compositeDisposable = CompositeDisposable()
    private var detailsPageUiModel: DetailsPageUiModel? = null

    override fun onViewStart() {
        if (detailsPageUiModel == null) {
            compositeDisposable.add(
                getOneDayWeatherUseCase.buildUseCase(GetOneDayWeatherUseCase.Params(dayId))
                    .subscribeOn(Schedulers.io())
                    .observeOn(uiScheduler)
                    .subscribe({
                        detailsPageUiModel = dayWeatherToWeatherListItemUiModelConverter.mapToPresentation(it)
                        detailsPageUiModel?.title?.let {
                            view.showTitle(it)
                        }
                    },{
                        println(it.localizedMessage)
                    })
            )
        }
    }

    override fun onViewStop() {
        compositeDisposable.clear()
    }

    override fun onViewDestroy() {
        compositeDisposable.dispose()
    }

    override fun onDownloadButtonPress() {
        detailsPageUiModel?.imageUrl?.let {
            view.showImage(it)
        }
    }
}
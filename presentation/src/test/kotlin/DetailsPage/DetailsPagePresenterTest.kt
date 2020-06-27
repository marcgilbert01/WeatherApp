package DetailsPage

import BaseRxTest
import WeatheList.DayWeatherToWeatherListItemUiModelConverter
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import com.nowtv.domain.common.BaseMapperToPresentation
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import weather.entitiy.DayWeather
import weather.usecase.GetOneDayWeatherUseCase


internal class DetailsPagePresenterTest : BaseRxTest() {

    private lateinit var cut: DetailsPagePresenter
    @Mock
    private lateinit var view: DetailsPageContract.View
    @Mock
    private lateinit var getOneDayWeatherUseCase: GetOneDayWeatherUseCase

    private var dayWeatherToWeatherListItemUiModelConverter = DayWeatherToDetailsPageUiModel()
    private val dayId = 32134
    private val weatherCondition = "Sunny"
    private val weatherConditionImageUrl = "http://image"
    private val dayWeather = DayWeather(
        dayId = dayId,
        weatherCondition = weatherCondition,
        weatherConditionImageUrl = weatherConditionImageUrl
    )

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        cut = DetailsPagePresenter(
            view =view,
            getOneDayWeatherUseCase = getOneDayWeatherUseCase,
            dayWeatherToWeatherListItemUiModelConverter = dayWeatherToWeatherListItemUiModelConverter,
            dayId = dayId
        )
        given(getOneDayWeatherUseCase.buildUseCase(any())).willReturn(Single.just(dayWeather))
    }

    @Test
    fun `given day id when view start then fetch day data and display weather`() {
        // when
        cut.onViewStart()

        // then
        verify(getOneDayWeatherUseCase).buildUseCase(any())
        verify(view).showTitle(weatherCondition)
    }

    @Test
    fun `given day id when download button click then display weather image`() {
        // when
        cut.onViewStart()
        cut.onDownloadButtonPress()

        // then
        verify(view).showImage(weatherConditionImageUrl)
    }
}
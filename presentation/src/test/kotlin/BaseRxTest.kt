import Rx.uiScheduler
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.mockito.ArgumentCaptor
import org.mockito.Mockito

open class BaseRxTest {
    init {
        setUpRxSchedulers()
    }

    private fun setUpRxSchedulers() {
        RxJavaPlugins.setIoSchedulerHandler { scheduler -> Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { scheduler -> Schedulers.trampoline() }
        uiScheduler = Schedulers.trampoline()
    }

    protected fun <T> any(type: Class<T>): T = Mockito.any<T>(type)

    protected fun <T> any(): T {
        Mockito.any<T>()
        return uninitialized()
    }
    private fun <T> uninitialized(): T = null as T

    protected fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()
}

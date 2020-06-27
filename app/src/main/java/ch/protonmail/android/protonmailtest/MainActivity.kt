package ch.protonmail.android.protonmailtest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = resources.getString(R.string.label_forecast)
        view_pager2.adapter = MainPagerAdapter(this)
        initTabs()
    }

    fun initTabs() {
        view_pager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    MainPagerAdapter.Pages.UPCOMING.ordinal -> {
                        upcoming_tab.alpha = 1F
                        hottest_tab.alpha = 0.5F
                    }
                    MainPagerAdapter.Pages.HOTTEST.ordinal -> {
                        hottest_tab.alpha = 1F
                        upcoming_tab.alpha = 0.5F
                    }
                }
            }
        })
        upcoming_tab.setOnClickListener {
            view_pager2.currentItem = MainPagerAdapter.Pages.UPCOMING.ordinal
        }
        hottest_tab.setOnClickListener {
            view_pager2.currentItem = MainPagerAdapter.Pages.HOTTEST.ordinal
        }
    }
}

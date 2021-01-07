package example.marc.android.weatherApp

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return Pages.values().size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            Pages.UPCOMING.ordinal -> UpcomingFragment()
            Pages.HOTTEST.ordinal -> HottestFragment()
            else -> UpcomingFragment()
        }
    }

    enum class Pages {
        UPCOMING,
        HOTTEST
    }

}

package ch.protonmail.android.protonmailtest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val pager = findViewById<ViewPager>(R.id.pager)
//        val adapter = TabsAdapter(this, supportFragmentManager)
//        pager.adapter = adapter

        view_pager2.adapter = MainPagerAdapter(this)
    }

    fun initTabs() {
        //TODO
    }
}

package gc.com.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.ViewPager
import android.view.MenuItem
import gc.com.myapplication.R.drawable.ic_menu
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_list_viewpager.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar!!.setHomeAsUpIndicator(ic_menu)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        nav_view.setNavigationItemSelectedListener { item ->
            Snackbar.make(nav_view, item.title.toString() + " pressed", Snackbar.LENGTH_LONG).show()
            item.isChecked = true
            drawer_layout.closeDrawers()
            true
        }
        setupViewPager(viewpager_cheese)
        tabs_cheese_group?.setupWithViewPager(viewpager_cheese)
    }

    private fun setupViewPager(viewPager: ViewPager) {

    }
}

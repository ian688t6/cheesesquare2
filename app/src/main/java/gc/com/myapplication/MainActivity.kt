package gc.com.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
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
        val adapter = Adapter(supportFragmentManager)
        /* Todo add Fragment List */
    }

    inner class Adapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
        private val m_fragments = ArrayList<Fragment>()
        private val m_fragmentTitles = ArrayList<String>()

        fun addFragment(fragment: Fragment, title: String) {
            m_fragments.add(fragment)
            m_fragmentTitles.add(title)
        }

        override fun getItem(position: Int): Fragment {
            return m_fragments[position]
        }

        override fun getCount(): Int {
            return m_fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return m_fragmentTitles[position]
        }
    }
}

package com.github.skyfe79.materialbottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val historyFragment: HistoryFragment by lazy {
        HistoryFragment()
    }

    private val favoriteFragment: FavoriteFragment by lazy {
        FavoriteFragment()
    }

    private val nearByFragment: NearByFragment by lazy {
        NearByFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, historyFragment)
            .commitAllowingStateLoss()

        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.action_history -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, historyFragment)
                        .commitAllowingStateLoss()
                }
                R.id.action_favorites -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, favoriteFragment)
                        .commitAllowingStateLoss()
                }
                R.id.action_nearby -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, nearByFragment)
                        .commitAllowingStateLoss()
                }
            }
            true
        }
    }
}

package com.example.shalomhalbert.rocketinsightsapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.shalomhalbert.rocketinsightsapp.fragments.DayListFragment

/**
 * Base activity for all fragments
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,
                DayListFragment.newInstance(), DayListFragment.TAG).commit()
    }
}

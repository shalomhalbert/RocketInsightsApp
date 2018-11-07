package com.example.shalomhalbert.rocketinsightsapp.shared

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.shalomhalbert.rocketinsightsapp.R
import com.example.shalomhalbert.rocketinsightsapp.neww.NewFragment
import com.example.shalomhalbert.rocketinsightsapp.old.OldFragment

/**
 * Base activity for all fragments
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showNewDayFrag()
    }

    private fun showOldDayFrag() {
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,
                OldFragment()).commit()
    }

    private fun showNewDayFrag() {
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,
                NewFragment()).commit()
    }
}

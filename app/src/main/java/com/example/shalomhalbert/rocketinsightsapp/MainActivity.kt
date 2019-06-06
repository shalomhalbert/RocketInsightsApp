package com.example.shalomhalbert.rocketinsightsapp.shared

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.transaction
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
        supportFragmentManager.transaction {
            add(R.id.fragmentContainer, OldFragment())
        }
    }

    private fun showNewDayFrag() {
        supportFragmentManager.transaction {
            add(R.id.fragmentContainer, NewFragment())
        }
    }
}

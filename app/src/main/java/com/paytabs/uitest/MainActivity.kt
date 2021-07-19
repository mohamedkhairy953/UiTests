package com.paytabs.uitest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.paytabs.uitest.recycler_test.RecyclerViewFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.fc_main, RecyclerViewFragment(), "")
            .commit()
    }
}
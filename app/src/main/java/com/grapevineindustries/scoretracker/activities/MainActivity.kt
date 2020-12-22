package com.grapevineindustries.scoretracker.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.NavigationUI
import com.grapevineindustries.scoretracker.R
import androidx.navigation.findNavController
import androidx.databinding.DataBindingUtil
import com.grapevineindustries.scoretracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val navController = this.findNavController(R.id.myNavHostFragment)

        // allows to display navDrawer
        NavigationUI.setupWithNavController(binding.navView, navController)
    }
}
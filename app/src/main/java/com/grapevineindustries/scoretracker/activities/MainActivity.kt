package com.grapevineindustries.scoretracker.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.utilities.ARG_NUM_PLAYERS
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_plus.setOnClickListener {
            var numPlayersInt = Integer.valueOf(tv_numPlayers.text.toString())
            numPlayersInt++
            tv_numPlayers.text = numPlayersInt.toString()
        }

        btn_minus.setOnClickListener {
            var numPlayersInt = Integer.valueOf(tv_numPlayers.text.toString())
            numPlayersInt--
            tv_numPlayers.text = numPlayersInt.toString()
        }

        btn_start.setOnClickListener {
            val productIntent = Intent(this, AddPlayerActivity::class.java)
            productIntent.putExtra(ARG_NUM_PLAYERS, tv_numPlayers.text.toString())
            startActivity(productIntent)
        }
    }
}

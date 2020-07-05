package com.grapevineindustries.scoretracker.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grapevineindustries.scoretracker.DisplayPlayersFragment
import com.grapevineindustries.scoretracker.EnterScoresFragment
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.model.Player
import com.grapevineindustries.scoretracker.utilities.*

class ComputeScoreActivity : AppCompatActivity(), Communicator {

    lateinit var playerList: ArrayList<Player>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blank)

        playerList = intent.getParcelableArrayListExtra(ARG_NUM_PLAYERS)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, DisplayPlayersFragment.newInstance(playerList, 3))
                .commitNow()
        }
    }

    override fun startDisplayFrag(wildcard: Int, players: ArrayList<Player>) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, DisplayPlayersFragment.newInstance(players, wildcard))
            .commitNow()
    }

    override fun startComputeFrag(wildcard: Int, players: ArrayList<Player>) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, EnterScoresFragment.newInstance(players, wildcard))
            .commitNow()
    }
}

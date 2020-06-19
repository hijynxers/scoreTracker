package com.grapevineindustries.scoretracker.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.iterator
import androidx.recyclerview.widget.LinearLayoutManager
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.adapters.ComputeScoreRecyclerAdapter
import com.grapevineindustries.scoretracker.model.Player
import com.grapevineindustries.scoretracker.utilities.EXTRA_NUM_PLAYERS
import kotlinx.android.synthetic.main.activity_compute_score.*
import kotlinx.android.synthetic.main.player_score_list_item.view.*

class ComputeScoreActivity : AppCompatActivity() {

    var wildcard = 3  // needs to start at 2 because will increment before displaying
    lateinit var playerList: ArrayList<Player>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compute_score)

        playerList = intent.getParcelableArrayListExtra(EXTRA_NUM_PLAYERS)
        val adapter = ComputeScoreRecyclerAdapter(this, playerList)

        rv_computeScore.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        rv_computeScore.layoutManager = layoutManager
    }

    fun onTallyScoreClicked(view: View) {
        val idx = Integer.valueOf(playerList.count()) - 1

        for (num in 0..idx) {
            val slot = rv_computeScore.getChildAt(num)

            val scoreToAdd = Integer.valueOf(slot.btn_calcScore.text.toString())
            println(playerList[num])
            playerList[num].score += scoreToAdd
            println(playerList[num])

            slot.tv_score.text = playerList[num].score.toString()
            slot.btn_calcScore.text = 0.toString()
        }
        updateWildcard()

        if (wildcard == 14) {
            tv_wildCard.text = "Game Over"
            btn_computeScore.isEnabled = false
            val toast = Toast.makeText(this, "Game is over", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private fun convertWildcard(): String {
        wildcard++
        return when(wildcard) {
            11 -> "J"
            12 -> "Q"
            13 -> "K"
            else -> wildcard.toString()
        }
    }

    private fun updateWildcard()
    {
        tv_wildCard.text = "${convertWildcard()}'s are wild"
    }
}

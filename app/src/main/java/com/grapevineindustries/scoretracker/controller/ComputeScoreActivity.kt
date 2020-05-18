package com.grapevineindustries.scoretracker.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.adapters.ComputeScoreRecyclerAdapter
import com.grapevineindustries.scoretracker.model.Player
import com.grapevineindustries.scoretracker.utilities.EXTRA_NUM_PLAYERS
import kotlinx.android.synthetic.main.activity_add_player.*
import kotlinx.android.synthetic.main.activity_compute_score.*
import kotlinx.android.synthetic.main.add_player_list_item.view.*
import kotlinx.android.synthetic.main.compute_score_list_item.*
import kotlinx.android.synthetic.main.compute_score_list_item.view.*
import kotlinx.android.synthetic.main.compute_score_list_item.view.tv_score

class ComputeScoreActivity : AppCompatActivity() {

    lateinit var playerList: ArrayList<Player>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compute_score)

        playerList = intent.getParcelableArrayListExtra(EXTRA_NUM_PLAYERS)
        val adapter = ComputeScoreRecyclerAdapter(this, "5")

        rv_computeScore.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        rv_computeScore.layoutManager = layoutManager
    }

    fun onTallyScoreClicked(view: View) {
        val idx = Integer.valueOf(playerList.count()) - 1
        Log.d("here__", idx.toString())
        for (num in 0..idx) {
            val slot = rv_computeScore.getChildAt(num)

            Log.d("here__", num.toString())
            var scoreToAdd = 0
            if (slot.et_score.text.toString() != "")
            {
                scoreToAdd = Integer.valueOf(slot.et_score.text.toString())
            }
            println(playerList[num])
            playerList[num].score += scoreToAdd
            println(playerList[num])

            slot.tv_score.text = playerList[num].score.toString()
            slot.et_score.text.clear()
        }
    }
}

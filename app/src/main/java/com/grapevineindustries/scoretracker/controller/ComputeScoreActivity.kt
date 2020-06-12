package com.grapevineindustries.scoretracker.controller

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.adapters.ComputeScoreRecyclerAdapter
import com.grapevineindustries.scoretracker.model.Player
import com.grapevineindustries.scoretracker.utilities.EXTRA_NUM_PLAYERS
import kotlinx.android.synthetic.main.activity_add_player.*
import kotlinx.android.synthetic.main.activity_compute_score.*
import kotlinx.android.synthetic.main.activity_popup_calc.*
import kotlinx.android.synthetic.main.activity_popup_calc.view.*
import kotlinx.android.synthetic.main.add_player_list_item.view.*
import kotlinx.android.synthetic.main.compute_score_list_item.*
import kotlinx.android.synthetic.main.compute_score_list_item.view.*
import kotlinx.android.synthetic.main.compute_score_list_item.view.tv_score

class ComputeScoreActivity : AppCompatActivity() {

    var wildcard = 2  // needs to start at 2 because will increment before displaying
    lateinit var playerList: ArrayList<Player>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compute_score)

        playerList = intent.getParcelableArrayListExtra(EXTRA_NUM_PLAYERS)
        val adapter = ComputeScoreRecyclerAdapter(this, playerList)

        rv_computeScore.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        rv_computeScore.layoutManager = layoutManager
        updateWildcard()




    }

    fun onTallyScoreClicked(view: View) {
        val idx = Integer.valueOf(playerList.count()) - 1
        Log.d("here__", idx.toString())
        for (num in 0..idx) {
            val slot = rv_computeScore.getChildAt(num)

            Log.d("here__", num.toString())
            var scoreToAdd = Integer.valueOf(slot.btn_calcScore.text.toString())
            println(playerList[num])
            playerList[num].score += scoreToAdd
            println(playerList[num])

            slot.tv_score.text = playerList[num].score.toString()
            slot.btn_calcScore.text = 0.toString()
        }
        updateWildcard()

        if (wildcard == 14) {
            tv_wildCard.text = "Game over"
            val toast = Toast.makeText(this, "Game is over", Toast.LENGTH_SHORT)
            toast.show()
        }
    }



    private fun add(lhs: Int, rhs: Int): String {
        return (lhs + rhs).toString()
    }

    fun clicked3(view: View) {
        //val n = Integer.valueOf(view.calcScore.text.toString())
        val n = 7
        val value: String = when(view) {
            view.btn_3 -> add(n, 3)
            view.btn_4 -> add(n, 4)
            view.btn_5 -> add(n, 5)
            view.btn_6 -> add(n, 6)
            view.btn_7 -> add(n, 7)
            view.btn_8 -> add(n, 8)
            view.btn_9 -> add(n, 9)
            view.btn_10 -> add(n, 10)
            view.btn_j -> add(n, 11)
            view.btn_q -> add(n, 12)
            view.btn_k -> add(n, 13)
            view.btn_20 -> add(n, 20)
            view.btn_50 -> add(n, 50)
            else -> add(n, 0)
        }
        view.calcScore.text = value
    }

    fun convertWildcard(): String {
        wildcard++
        return when(wildcard) {
            11 -> "J"
            12 -> "Q"
            13 -> "K"
            else -> wildcard.toString()
        }
    }

    fun updateWildcard()
    {
        tv_wildCard.text = "${convertWildcard()}'s are wild"
    }
}

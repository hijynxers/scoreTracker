package com.grapevineindustries.scoretracker.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grapevineindustries.scoretracker.DisplayPlayersFragment
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.model.Player
import com.grapevineindustries.scoretracker.utilities.ARG_NUM_PLAYERS

class ComputeScoreActivity : AppCompatActivity() {

    //var wildcard = 3  // needs to start at 2 because will increment before displaying
    lateinit var playerList: ArrayList<Player>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blank)

        playerList = intent.getParcelableArrayListExtra(ARG_NUM_PLAYERS)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, DisplayPlayersFragment.newInstance(playerList, "3"))
                .commitNow()
        }
//        val adapter = ComputeScoreRecyclerAdapter(this, playerList)
//
//        rv_computeScore.adapter = adapter
//
//        val layoutManager = LinearLayoutManager(this)
//        rv_computeScore.layoutManager = layoutManager
    }

//    fun onTallyScoreClicked(view: View) {
//        val idx = Integer.valueOf(playerList.count()) - 1
//
//        for (num in 0..idx) {
//            val slot = rv_computeScore.getChildAt(num)
//
//            val scoreToAdd = Integer.valueOf(slot.btn_calcScore.text.toString())
//            println(playerList[num])
//            playerList[num].score += scoreToAdd
//            println(playerList[num])
//
//            slot.tv_score.text = playerList[num].score.toString()
//            slot.btn_calcScore.text = 0.toString()
//        }
//        updateWildcard()
//
//        if (wildcard == 14) {
//            tv_wildCard.text = "Game Over"
//            btn_computeScore.isEnabled = false
//            val toast = Toast.makeText(this, "Game is over", Toast.LENGTH_SHORT)
//            toast.show()
//        }
//    }
//
//    private fun convertWildcard(): String {
//        wildcard++
//        return when(wildcard) {
//            11 -> "J"
//            12 -> "Q"
//            13 -> "K"
//            else -> wildcard.toString()
//        }
//    }
//
//    private fun updateWildcard()
//    {
//        tv_wildCard.text = "${convertWildcard()}'s are wild"
//    }
}

package com.grapevineindustries.scoretracker.gameLogic

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.adapters.GameAdapter
import com.grapevineindustries.scoretracker.databinding.FragmentGameBinding
import com.grapevineindustries.scoretracker.fragments.GameFragmentDirections
import com.grapevineindustries.scoretracker.models.Players
import com.grapevineindustries.scoretracker.utilities.GLOBAL_DEALER_IDX

class Rummy {

    fun play(binding: FragmentGameBinding, playerList: Players, activity: FragmentActivity?, context: Context?, gameType: String) {
        // clear the "wild card" text from the screen
        binding.gameTvWild.text = ""
        binding.gameTvCard.text = ""
        binding.gameTvWildCard.text = ""

        // create instance of the adapter
        val adapter = GameAdapter(playerList, gameType)
        // let the recycler view know about the adapter
        binding.gameRecycler.adapter = adapter

        val manager = LinearLayoutManager(activity)
        binding.gameRecycler.layoutManager = manager
        binding.gameBtnTallyScore.setOnClickListener { view: View ->

            var allZero = true
     //       var keepGoing = true
            for (i in 0 until playerList.size) {
                val slot = binding.gameRecycler.getChildAt(i)
                val scoreToAdd = slot.findViewById<Button>(R.id.list_item_game_calcScoreBtn)
                if (scoreToAdd.text.toString() != "0") {
                    allZero = false
                }
            }
            if (allZero) {
                context?.let {
                    MaterialAlertDialogBuilder(it, R.style.AlertDialogTheme_FiveCrowns)
                            .setMessage("Do you want to continue?")
                            .setPositiveButton("Continue") { _, _ ->
                                ++GLOBAL_DEALER_IDX
                                nextRound(playerList, binding, view, context, gameType)
                            }
                            .setNegativeButton("Return") { _, _ ->
                               // keepGoing = false
                            }
                            .show()
                }
            } else {
                ++GLOBAL_DEALER_IDX
                nextRound(playerList, binding, view, context, gameType)
            }
        }
    }

    private fun nextRound(playerList: Players, binding: FragmentGameBinding, view: View, context: Context?, gameType: String) {
        updateScores(playerList, binding)

        if(playerList.maxOf { it -> it.score } >= 500) {
            // start new thing
            view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameOverFragment(playerList, gameType))
        } else {
            updatedDisplay(playerList, binding, view, context)
        }
    }

    private fun updateScores(playerList: Players, binding: FragmentGameBinding) {
        for (i in 0 until playerList.size) {
            val slot = binding.gameRecycler.getChildAt(i)
            val scoreToAdd = slot.findViewById<Button>(R.id.list_item_game_calcScoreBtn)
            playerList[i].score += scoreToAdd.text.toString().toInt()
        }
    }

    private fun updatedDisplay(playerList: Players, binding: FragmentGameBinding, view: View, context: Context?) {
        // down here, update score and display
        for (i in 0 until playerList.size) {
            val slot = binding.gameRecycler.getChildAt(i)
            val scoreToAdd = slot.findViewById<Button>(R.id.list_item_game_calcScoreBtn)
            scoreToAdd.text = "0"

            // display the new score
            val score = slot.findViewById<TextView>(R.id.list_item_game_score)
            score.text = playerList[i].score.toString()

            if (i == (GLOBAL_DEALER_IDX % playerList.size)) {
                if (context != null) {
                    slot.setBackgroundColor(ContextCompat.getColor(view.context, R.color.colorPrimaryLight))
                }
            }
            else {
                if (context != null) {
                    slot.setBackgroundColor(ContextCompat.getColor(view.context, R.color.colorPrimary))
                }
            }
        }
    }
}
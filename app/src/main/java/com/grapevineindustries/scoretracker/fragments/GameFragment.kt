package com.grapevineindustries.scoretracker.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.adapters.GameAdapter
import com.grapevineindustries.scoretracker.databinding.FragmentGameBinding
import com.grapevineindustries.scoretracker.models.Players
import com.grapevineindustries.scoretracker.utilities.GLOBAL_DEALER_IDX

class GameFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater, R.layout.fragment_game, container, false)
        val args = GameFragmentArgs.fromBundle(requireArguments())
        val playerList = args.playerList

        var round = 3

        binding.gameTvWildCard.text = round.toString()

        // create instance of the adapter
        val adapter = GameAdapter(playerList)
        // let the recycler view know about the adapter
        binding.gameRecycler.adapter = adapter

        val manager = LinearLayoutManager(activity)
        binding.gameRecycler.layoutManager = manager
        binding.gameBtnTallyScore.setOnClickListener { view: View ->

            var allZero = true
            var keepGoing = false
            for (i in 0 until playerList.size) {
                val slot = binding.gameRecycler.getChildAt(i)
                val scoreToAdd = slot.findViewById<Button>(R.id.list_item_game_calcScoreBtn)
                if (scoreToAdd.text.toString() != "0") {
                    allZero = false
                }
            }
            if (allZero) {
                context?.let {
                    MaterialAlertDialogBuilder(it, R.style.AlertDialogTheme)
                        .setMessage("Do you want to continue?")
                        .setPositiveButton("Yes") { _, _ ->
                            ++GLOBAL_DEALER_IDX
                            ++round
                            nextRound(round, playerList, binding, view)
                        }
                        .setNegativeButton("No") { _, _ ->
                            keepGoing = false
                        }
                        .show()
                }
            } else {
                keepGoing = true
            }

            if (keepGoing){
                ++GLOBAL_DEALER_IDX
                ++round
                nextRound(round, playerList, binding, view)
            }
        }

        return binding.root
    }

    private fun nextRound(round: Int, playerList: Players, binding: FragmentGameBinding, view: View) {
        if(round == 14) {
            // for each of these just update the score, don't need to display
            updateScores(playerList, binding)

            // start new thing
            view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameOverFragment(playerList))
        } else {
            updateScores(playerList, binding)
            updatedDisplay(playerList, binding, view)
            binding.gameTvWildCard.text = updateWildcard(round)
        }
    }

    private fun updateScores(playerList: Players, binding: FragmentGameBinding) {
        for (i in 0 until playerList.size) {
            val slot = binding.gameRecycler.getChildAt(i)
            val scoreToAdd = slot.findViewById<Button>(R.id.list_item_game_calcScoreBtn)
            playerList[i].score += scoreToAdd.text.toString().toInt()
        }
    }

    private fun updatedDisplay(playerList: Players, binding: FragmentGameBinding, view: View) {
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
                    slot.setBackgroundColor(ContextCompat.getColor(view.context, R.color.purple_light))
                }
            }
            else {
                if (context != null) {
                    slot.setBackgroundColor(ContextCompat.getColor(view.context, R.color.colorPrimary))
                }
            }
        }
    }

    private fun updateWildcard(wildcard: Int): String {
        return when(wildcard) {
            11 -> "J"
            12 -> "Q"
            13 -> "K"
            else -> wildcard.toString()
        }
    }
}


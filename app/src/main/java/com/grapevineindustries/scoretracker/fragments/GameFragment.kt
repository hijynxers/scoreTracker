package com.grapevineindustries.scoretracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.databinding.FragmentGameBinding
import com.grapevineindustries.scoretracker.gameLogic.*
import com.grapevineindustries.scoretracker.utilities.*

class GameFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater, R.layout.fragment_game, container, false)
        val args = GameFragmentArgs.fromBundle(requireArguments())
        val playerList = args.playerList

        when (val gameType = args.gameType) {
            GLOBAL_GAME_FIVE_CROWNS -> {
                val fiveCrowns = FiveCrowns()
                fiveCrowns.play(binding, playerList, activity, context, gameType)
            }
            GLOBAL_GAME_RUMMY -> {
                val rummy = Rummy()
                rummy.play(binding, playerList, activity, context, gameType)
            }
        }

        return binding.root
    }


}


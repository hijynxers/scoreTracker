package com.grapevineindustries.scoretracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.databinding.FragmentGameBinding
import com.grapevineindustries.scoretracker.gameLogic.FiveCrowns

class GameFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater, R.layout.fragment_game, container, false)
        val args = GameFragmentArgs.fromBundle(requireArguments())
        val playerList = args.playerList
        val gameType = args.gameType

        val fiveCrowns = FiveCrowns()

        if (gameType == "FIVE_CROWNS")
        {
            fiveCrowns.play(binding, playerList, activity, context, gameType)
        }



        return binding.root
    }


}


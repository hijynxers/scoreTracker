package com.grapevineindustries.scoretracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.adapters.GameAdapter
import com.grapevineindustries.scoretracker.databinding.FragmentGameBinding

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
            
        }


        return binding.root
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
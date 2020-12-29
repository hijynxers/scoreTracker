package com.grapevineindustries.scoretracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.grapevineindustries.scoretracker.models.Players
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.adapters.GameOverAdapter
import com.grapevineindustries.scoretracker.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentGameOverBinding>(inflater, R.layout.fragment_game_over, container, false)
        val args = GameFragmentArgs.fromBundle(requireArguments())

        val numPlayers =  args.playerList.size
        val sortedList =  args.playerList.sortedWith(compareBy { it.score })

        val sortedLists = Players()
        for(player in sortedList) {
            sortedLists.add(player)
        }

        val manager = LinearLayoutManager(context)
        binding.gameOverRecycler.layoutManager = manager
        val adapter = GameOverAdapter(sortedLists)
        binding.gameOverRecycler.adapter = adapter
        
        binding.gameOverReplayBtn.setOnClickListener { view : View ->
            for (player in args.playerList) {
                player.score = 0
            }
            view.findNavController().navigate(GameOverFragmentDirections.actionGameOverFragmentToAddPlayersFragment(numPlayers))
        }

        return binding.root
    }
}
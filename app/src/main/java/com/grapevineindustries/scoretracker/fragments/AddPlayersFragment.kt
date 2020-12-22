package com.grapevineindustries.scoretracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.grapevineindustries.scoretracker.Player
import com.grapevineindustries.scoretracker.Players
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.adapters.AddPlayerAdapter
import com.grapevineindustries.scoretracker.databinding.FragmentAddPlayersBinding

class AddPlayersFragment : Fragment() {

    lateinit var adapter: AddPlayerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentAddPlayersBinding>(inflater, R.layout.fragment_add_players, container, false)
        val args = AddPlayersFragmentArgs.fromBundle(requireArguments())

        val playerList = initPlayerList(args.numPlayers)

        // create instance of the adapter
        val adapter = AddPlayerAdapter(playerList, args.numPlayers)
        // let the recycler view know about the adapter
        binding.addPlayerRecycler.adapter = adapter

        val manager = LinearLayoutManager(activity)
        binding.addPlayerRecycler.layoutManager = manager


        binding.btnStartGame.setOnClickListener { view : View ->
            val idx = args.numPlayers - 1

            for(num in 0..idx) {
                val child = binding.addPlayerRecycler.getChildAt(num)
                val et = child.findViewById<EditText>(R.id.editText)
                val name = et.text.toString()
                playerList[num].name = name
            }

            view.findNavController().navigate(AddPlayersFragmentDirections.actionAddPlayersFragmentToGameFragment(playerList))
        }

        return binding.root
    }

    private fun initPlayerList(numPlayers: Int): Players {
        val playerList = Players()
        for(num in 1..numPlayers) {
            playerList.add(Player(""))
        }
        return playerList
    }
}
package com.grapevineindustries.scoretracker.fragments

import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.adapters.AddPlayerAdapter
import com.grapevineindustries.scoretracker.databinding.FragmentAddPlayersBinding
import com.grapevineindustries.scoretracker.models.Player
import com.grapevineindustries.scoretracker.models.Players
import com.grapevineindustries.scoretracker.utilities.GLOBAL_GAME_FIVE_CROWNS
import com.grapevineindustries.scoretracker.utilities.GLOBAL_GAME_RUMMY


class AddPlayersFragment : Fragment() {

    lateinit var adapter: AddPlayerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // hide the action bar
        (activity as AppCompatActivity).supportActionBar?.hide()

        val binding = DataBindingUtil.inflate<FragmentAddPlayersBinding>(inflater, R.layout.fragment_add_players, container, false)
        val args = AddPlayersFragmentArgs.fromBundle(requireArguments())

        val playerList = initPlayerList(args.numPlayers)
        val gameType = args.gameType

        // create instance of the adapter
        val adapter = AddPlayerAdapter(playerList, args.numPlayers)
        // let the recycler view know about the adapter
        binding.addPlayerRecycler.adapter = adapter

        val manager = LinearLayoutManager(activity)
        binding.addPlayerRecycler.layoutManager = manager


        binding.btnStartGame.setOnClickListener { view: View ->
            for(num in 0 until args.numPlayers) {
                val child = binding.addPlayerRecycler.getChildAt(num)
                val et = child.findViewById<EditText>(R.id.editText)
                val name = et.text.toString()
                playerList[num].name = name
            }

            view.findNavController().navigate(AddPlayersFragmentDirections.actionAddPlayersFragmentToGameFragment(playerList, gameType))
        }

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // in here you can do logic when backPress is clicked
                (activity as AppCompatActivity).supportActionBar?.show()
                if (gameType == GLOBAL_GAME_FIVE_CROWNS) {
                    //view?.findNavController()?.navigate(AddPlayersFragmentDirections.actionAddPlayersFragmentToFiveCrownsTitleFragment())
                } else if (gameType == GLOBAL_GAME_RUMMY) {
                 //   view?.findNavController()?.navigate(AddPlayersFragmentDirections.actionAddPlayersFragmentToRummyTitleFragment())
                }
            }
        })

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
package com.grapevineindustries.scoretracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.grapevineindustries.scoretracker.adapters.DisplayPlayersRecyclerAdapter
import com.grapevineindustries.scoretracker.model.Player
import com.grapevineindustries.scoretracker.utilities.*
import kotlinx.android.synthetic.main.activity_display_score.view.*
import kotlinx.android.synthetic.main.fragment_compute_score.view.*

class DisplayPlayersFragment : Fragment() {

    private lateinit var playerList: ArrayList<Player>
    private var wildcard: Int = -1
    private lateinit var comm: Communicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            playerList = it.getParcelableArrayList<Player>(ARG_PLAYER_LIST) as ArrayList<Player>
            wildcard = it.getInt(ARG_WILDCARD)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_display_score, container, false)


        val layoutManager = LinearLayoutManager(context)
        val adapter = context?.let { DisplayPlayersRecyclerAdapter(it, playerList) }

        view.displayScore_recycler.adapter = adapter
        view.displayScore_recycler.layoutManager = layoutManager

        view.displayScore_wildCard.text = updateWildcard(wildcard)

        comm = activity as Communicator
        view.displayScore_EnterScore.setOnClickListener {
            comm.startComputeFrag(wildcard, playerList)
        }

        return view
    }

    private fun updateWildcard(wildcard: Int): String {
        return when(wildcard) {
            11 -> "J"
            12 -> "Q"
            13 -> "K"
            else -> wildcard.toString()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(players: ArrayList<Player>, wildcard: Int) =
            DisplayPlayersFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_PLAYER_LIST, players)
                    putInt(ARG_WILDCARD, wildcard)
                }
            }
    }
}
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

class DisplayPlayersFragment : Fragment() {

    private lateinit var playerList: ArrayList<Player>
    private var wildcard: String = "-1"
    private lateinit var comm: Communicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

      //  wildcard = arguments?.getString(ARG_WILDCARD).toString()
      //  playerList = arguments?.getParcelableArrayList<Player>(ARG_PLAYER_LIST) as ArrayList<Player>

        arguments?.let {
            playerList = it.getParcelableArrayList<Player>(ARG_PLAYER_LIST) as ArrayList<Player>
            wildcard = it.getString(ARG_WILDCARD).toString()
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

        view.displayScore_wildCard.text = wildcard

        comm = activity as Communicator
        view.displayScore_EnterScore.setOnClickListener {
            comm.startComputeFrag(wildcard, playerList)
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(players: ArrayList<Player>, wildcard: String) =
            DisplayPlayersFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_PLAYER_LIST, players)
                    putString(ARG_WILDCARD, wildcard)
                }
            }
    }
}
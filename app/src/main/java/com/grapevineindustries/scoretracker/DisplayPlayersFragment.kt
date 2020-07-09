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
import kotlinx.android.synthetic.main.fragment_display_score.view.*
import java.util.*
import kotlin.collections.ArrayList

class DisplayPlayersFragment : Fragment() {

    private lateinit var playerList: ArrayList<Player>
    private lateinit var comm: Communicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            playerList = it.getParcelableArrayList<Player>(ARG_PLAYER_LIST) as ArrayList<Player>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_display_score, container, false)

        val layoutManager = LinearLayoutManager(context)

        var sortedList = playerList.sortedWith(compareBy { it.score })

        val adapter = context?.let { DisplayPlayersRecyclerAdapter(it, ArrayList(sortedList)) }

        view.displayScore_recycler.adapter = adapter
        view.displayScore_recycler.layoutManager = layoutManager

        comm = activity as Communicator

        view.displayScore_replayBtn.setOnClickListener {
            activity!!.finish()
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(players: ArrayList<Player>) =
            DisplayPlayersFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_PLAYER_LIST, players)
                }
            }
    }
}
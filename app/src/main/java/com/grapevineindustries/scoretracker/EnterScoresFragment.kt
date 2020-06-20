package com.grapevineindustries.scoretracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.grapevineindustries.scoretracker.adapters.ComputeScoreRecyclerAdapter
import com.grapevineindustries.scoretracker.model.Player
import com.grapevineindustries.scoretracker.utilities.ARG_PLAYER_LIST
import kotlinx.android.synthetic.main.activity_compute_score.view.*
import kotlinx.android.synthetic.main.activity_display_score.view.*

/**
 * A fragment representing a list of Items.
 */
class EnterScoresFragment : Fragment() {

    private lateinit var playerList: ArrayList<Player>

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
        val view = inflater.inflate(R.layout.activity_compute_score, container, false)

        val layoutManager = LinearLayoutManager(context)
        val adapter = context?.let { ComputeScoreRecyclerAdapter(it, playerList) }

        view.computeScore_recycler.adapter = adapter
        view.computeScore_recycler.layoutManager = layoutManager

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(players: ArrayList<Player>) =
            EnterScoresFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_PLAYER_LIST, players)
                }
            }
    }
}
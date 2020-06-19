package com.grapevineindustries.scoretracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.grapevineindustries.scoretracker.adapters.ComputeScoreRecyclerAdapter
import com.grapevineindustries.scoretracker.model.Player
import kotlinx.android.synthetic.main.activity_display_score.*
import kotlinx.android.synthetic.main.activity_display_score.view.*

/**
 * A fragment representing a list of Items.
 */
class DisplayPlayersFragment : Fragment() {

    private lateinit var playerList: ArrayList<Player>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            playerList = it.getParcelableArrayList<Player>(ARG_COLUMN_COUNT) as ArrayList<Player>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_display_score, container, false)

        val layoutManager = LinearLayoutManager(context)
        val adapter = context?.let { ComputeScoreRecyclerAdapter(it, playerList) }

        view.displayScore_recycler.adapter = adapter
        view.displayScore_recycler.layoutManager = layoutManager

        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(players: ArrayList<Player>) =
            DisplayPlayersFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_COLUMN_COUNT, players)
                }
            }
    }
}
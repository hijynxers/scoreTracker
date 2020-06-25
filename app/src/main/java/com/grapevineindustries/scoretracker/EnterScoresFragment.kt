package com.grapevineindustries.scoretracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.grapevineindustries.scoretracker.adapters.ComputeScoreRecyclerAdapter
import com.grapevineindustries.scoretracker.model.Player
import com.grapevineindustries.scoretracker.utilities.ARG_PLAYER_LIST
import com.grapevineindustries.scoretracker.utilities.ARG_WILDCARD
import com.grapevineindustries.scoretracker.utilities.Communicator
import kotlinx.android.synthetic.main.fragment_compute_score.view.*

/**
 * A fragment representing a list of Items.
 */
class EnterScoresFragment : Fragment() {

    private lateinit var playerList: ArrayList<Player>
    private lateinit var comm: Communicator
    private var wildcard: String = "-1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            playerList = it.getParcelableArrayList<Player>(ARG_PLAYER_LIST) as ArrayList<Player>
            wildcard = it.getString(ARG_WILDCARD).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_compute_score, container, false)

        val layoutManager = LinearLayoutManager(context)
        val adapter = context?.let { ComputeScoreRecyclerAdapter(it, playerList) }

        view.computeScore_recycler.adapter = adapter
        view.computeScore_recycler.layoutManager = layoutManager

        view.computeScore_tv_wildCard.text = wildcard

        comm = activity as Communicator
        view.computeScore_btn_tallyScore.setOnClickListener {
            val intCard: Int = wildcard.toInt() + 1
            val updatedCard: String = updateWildcard(intCard)
            comm.startDisplayFrag(updatedCard, playerList)
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
        fun newInstance(players: ArrayList<Player>, wildcard: String) =
            EnterScoresFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_PLAYER_LIST, players)
                    putString(ARG_WILDCARD, wildcard)
                }
            }
    }
}
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
import kotlinx.android.synthetic.main.fragment_compute_score.*
import kotlinx.android.synthetic.main.fragment_compute_score.view.*
import kotlinx.android.synthetic.main.list_item_compute_score.view.*

/**
 * A fragment representing a list of Items.
 */
class EnterScoresFragment : Fragment() {

    private lateinit var playerList: ArrayList<Player>
    private lateinit var comm: Communicator
    private var wildcard: Int = -1

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
        val view = inflater.inflate(R.layout.fragment_compute_score, container, false)

        val layoutManager = LinearLayoutManager(context)
        val adapter = context?.let { ComputeScoreRecyclerAdapter(it, playerList) }

        view.computeScore_recycler.adapter = adapter
        view.computeScore_recycler.layoutManager = layoutManager

        view.computeScore_tv_wildCard.text = updateWildcard(wildcard)

        comm = activity as Communicator
        view.computeScore_btn_tallyScore.setOnClickListener {
            val intCard: Int = wildcard + 1

            val idx = Integer.valueOf(playerList.count()) - 1
            for (num in 0..idx) {
                // grab the slot we are at
                val slot = computeScore_recycler.getChildAt(num)
                // get the number to add to the score
                val scoreToAdd = Integer.valueOf(slot.btn_calcScore.text.toString())
                // add the score to the player
                playerList[num].score += scoreToAdd
            }

            comm.startDisplayFrag(intCard, playerList)
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
            EnterScoresFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_PLAYER_LIST, players)
                    putInt(ARG_WILDCARD, wildcard)
                }
            }
    }
}
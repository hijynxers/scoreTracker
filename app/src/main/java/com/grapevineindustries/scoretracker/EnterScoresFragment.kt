package com.grapevineindustries.scoretracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.grapevineindustries.scoretracker.adapters.ComputeScoreRecyclerAdapter
import com.grapevineindustries.scoretracker.model.Player
import com.grapevineindustries.scoretracker.utilities.ARG_PLAYER_LIST
import com.grapevineindustries.scoretracker.utilities.ARG_WILDCARD
import com.grapevineindustries.scoretracker.utilities.Communicator
import com.grapevineindustries.scoretracker.utilities.GLOBAL_DEALER_IDX
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
            wildcard++
            GLOBAL_DEALER_IDX++

            view.computeScore_tv_wildCard.text = wildcard.toString()

            val idx = Integer.valueOf(playerList.count()) - 1
            for (position in 0..idx) {
                // grab the slot we are at
                val slot = computeScore_recycler.getChildAt(position)
                // get the number to add to the score
                val scoreToAdd = Integer.valueOf(slot.computeScore_calcScoreBtn.text.toString())
                // add the score to the player
                playerList[position].score += scoreToAdd

                slot.computeScore_score.text = playerList[position].score.toString()
                slot.computeScore_calcScoreBtn.text = 0.toString()

                if (position == (GLOBAL_DEALER_IDX % playerList.size)) {
                    if (context != null) {
                        slot.setBackgroundColor(ContextCompat.getColor(context!!, R.color.colorDealerTab))
                    }
                }
                else {
                    if (context != null) {
                        slot.setBackgroundColor(ContextCompat.getColor(context!!, R.color.colorPrimary))
                    }
                }
            }


            if (wildcard == 14) {
                comm.startDisplayFrag(playerList)
            }
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
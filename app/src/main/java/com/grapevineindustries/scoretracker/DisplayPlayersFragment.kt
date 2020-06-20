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
        val view = inflater.inflate(R.layout.activity_display_score, container, false)

        val layoutManager = LinearLayoutManager(context)
        val adapter = context?.let { DisplayPlayersRecyclerAdapter(it, playerList) }

        view.displayScore_recycler.adapter = adapter
        view.displayScore_recycler.layoutManager = layoutManager

        view.displayScore_wildCard.text = wildcard

        view.displayScore_EnterScore.setOnClickListener {
            // if wild card is 3 start new fragment
            if (wildcard == "3")
            {
                childFragmentManager.beginTransaction()
                    .remove(this)
                    .replace(R.id.container_display_score, EnterScoresFragment.newInstance(playerList))
                    .commit()
            }
            else
            {
                activity?.supportFragmentManager?.popBackStack()
            }
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
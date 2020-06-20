package com.grapevineindustries.scoretracker.adapters

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.model.Player
import kotlinx.android.synthetic.main.dialog_popup_calc.*
import kotlinx.android.synthetic.main.list_item_compute_score.view.btn_calcScore

class DisplayPlayersRecyclerAdapter(val context: Context, val players: ArrayList<Player>): RecyclerView.Adapter<DisplayPlayersRecyclerAdapter.ComputeScoreHolder>() {

    inner class ComputeScoreHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView? = itemView.findViewById(R.id.display_playerName)
        val score: TextView? = itemView.findViewById(R.id.display_playerScore)

        fun bindComputeScore(player: Player, context: Context) {
            name?.text = player.name
            score?.text = player.score.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComputeScoreHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_display_score, parent, false)
        return ComputeScoreHolder(view)
    }

    override fun getItemCount(): Int {
        return Integer.valueOf(players.count())
    }

    override fun onBindViewHolder(holder: ComputeScoreHolder, position: Int) {
        holder.bindComputeScore(players[position], context)
    }
}

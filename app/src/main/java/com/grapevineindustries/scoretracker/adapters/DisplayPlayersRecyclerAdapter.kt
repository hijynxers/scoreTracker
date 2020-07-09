package com.grapevineindustries.scoretracker.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.model.Player
import com.grapevineindustries.scoretracker.utilities.GLOBAL_DEALER_IDX

class DisplayPlayersRecyclerAdapter(val context: Context, val players: ArrayList<Player>): RecyclerView.Adapter<DisplayPlayersRecyclerAdapter.ComputeScoreHolder>() {

    inner class ComputeScoreHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView? = itemView.findViewById(R.id.display_playerName)
        val score: TextView? = itemView.findViewById(R.id.display_playerScore)

        fun bindComputeScore(player: Player, context: Context, position: Int) {
            this.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))

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
        holder.bindComputeScore(players[position], context, position)
    }
}

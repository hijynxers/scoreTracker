package com.grapevineindustries.scoretracker.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.model.Player

class ComputeScoreRecyclerAdapter(val context: Context, val players: ArrayList<Player>): RecyclerView.Adapter<ComputeScoreRecyclerAdapter.ComputeScoreHolder>() {

    inner class ComputeScoreHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView? = itemView.findViewById(R.id.tv_name)
        val score: TextView? = itemView.findViewById(R.id.tv_score)
        val addScore: EditText? = itemView.findViewById(R.id.et_score)

        fun bindComputeScore(player: Player, context: Context) {
            name?.text = player.name
            score?.text = player.score.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComputeScoreHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.compute_score_list_item, parent, false)
        return ComputeScoreHolder(view)
    }

    override fun getItemCount(): Int {
        return Integer.valueOf(players.count())
    }

    override fun onBindViewHolder(holder: ComputeScoreHolder, position: Int) {
        println("we got here")
        holder.bindComputeScore(players[position], context)
    }
}

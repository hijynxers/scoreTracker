package com.grapevineindustries.scoretracker.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grapevineindustries.scoretracker.R

class ComputeScoreRecyclerAdapter(val context: Context, val players: String): RecyclerView.Adapter<ComputeScoreRecyclerAdapter.ComputeScoreHolder>() {

    inner class ComputeScoreHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComputeScoreHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.compute_score_list_item, parent, false)
        return ComputeScoreHolder(view)
    }

    override fun getItemCount(): Int {
        return Integer.valueOf(players)
    }

    override fun onBindViewHolder(holder: ComputeScoreHolder, position: Int) {
        println("we got here")
    }
}

package com.grapevineindustries.scoretracker.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grapevineindustries.scoretracker.R

class AddPlayerRecyclerAdapter(val context: Context, val players: String): RecyclerView.Adapter<AddPlayerRecyclerAdapter.AddPlayerHolder>() {

    inner class AddPlayerHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddPlayerHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_add_player, parent, false)
        return AddPlayerHolder(view)
    }

    override fun getItemCount(): Int {
        return Integer.valueOf(players)
    }

    override fun onBindViewHolder(holder: AddPlayerHolder, position: Int) {
        println("we got here")
    }
}
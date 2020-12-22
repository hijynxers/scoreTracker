package com.grapevineindustries.scoretracker.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.grapevineindustries.scoretracker.Player
import com.grapevineindustries.scoretracker.databinding.ListItemAddPlayerBinding

class AddPlayerAdapter(private val playerList: MutableList<Player>, private val numPlayers: Int): RecyclerView.Adapter<AddPlayerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(playerList[position])
    }

    override fun getItemCount(): Int = numPlayers

    class ViewHolder (private val binding: ListItemAddPlayerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(player: Player) {
            binding.player = player
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemAddPlayerBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}


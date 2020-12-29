package com.grapevineindustries.scoretracker.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grapevineindustries.scoretracker.models.Player
import com.grapevineindustries.scoretracker.models.Players
import com.grapevineindustries.scoretracker.databinding.ListItemGameOverBinding

class GameOverAdapter(private val players: Players): RecyclerView.Adapter<GameOverAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(players[position])
    }

    override fun getItemCount() = players.size

    class ViewHolder(private val binding: ListItemGameOverBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(player: Player) {
            binding.displayPlayerName.text = player.name.toString()
            binding.displayPlayerScore.text = player.score.toString()
        }

        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemGameOverBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}
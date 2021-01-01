package com.grapevineindustries.scoretracker.adapters

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.grapevineindustries.scoretracker.models.Player
import com.grapevineindustries.scoretracker.models.Players
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.databinding.ListItemGameBinding
import com.grapevineindustries.scoretracker.utilities.GLOBAL_DEALER_IDX

class GameAdapter(private val players: Players): RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(players[position], position, players.size)
    }

    override fun getItemCount() = players.size

    class ViewHolder (private val binding: ListItemGameBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(player: Player, position: Int, size: Int) {
            if (position == (GLOBAL_DEALER_IDX % size)) {
                binding.root.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.purple_light))
            }
            binding.listItemGameName.text = player.name
        }

        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemGameBinding.inflate(layoutInflater, parent, false)

                binding.listItemGameCalcScoreBtn.setOnClickListener { view: View ->
                    val builder = MaterialAlertDialogBuilder(parent.context)
                    val dialogLayout = layoutInflater.inflate(R.layout.dialog_popup_calc, null)
                    builder.setView(dialogLayout)

                    val tvScore = dialogLayout.findViewById<TextView>(R.id.calcScore)

                    val btn3 = dialogLayout.findViewById<Button>(R.id.btn_3)
                    btn3.setOnClickListener { _: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 3).toString()
                    }
                    val btn4 = dialogLayout.findViewById<Button>(R.id.btn_4)
                    btn4.setOnClickListener { _: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 4).toString()
                    }
                    val btn5 = dialogLayout.findViewById<Button>(R.id.btn_5)
                    btn5.setOnClickListener { _: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 5).toString()
                    }
                    val btn6 = dialogLayout.findViewById<Button>(R.id.btn_6)
                    btn6.setOnClickListener { _: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 6).toString()
                    }
                    val btn7 = dialogLayout.findViewById<Button>(R.id.btn_7)
                    btn7.setOnClickListener { _: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 7).toString()
                    }
                    val btn8 = dialogLayout.findViewById<Button>(R.id.btn_8)
                    btn8.setOnClickListener { _: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 8).toString()
                    }
                    val btn9 = dialogLayout.findViewById<Button>(R.id.btn_9)
                    btn9.setOnClickListener { _: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 9).toString()
                    }
                    val btn10 = dialogLayout.findViewById<Button>(R.id.btn_10)
                    btn10.setOnClickListener { _: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 10).toString()
                    }
                    val btnJ = dialogLayout.findViewById<Button>(R.id.btn_j)
                    btnJ.setOnClickListener { _: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 11).toString()
                    }
                    val btnQ = dialogLayout.findViewById<Button>(R.id.btn_q)
                    btnQ.setOnClickListener { _: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 12).toString()
                    }
                    val btnK = dialogLayout.findViewById<Button>(R.id.btn_k)
                    btnK.setOnClickListener { _: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 13).toString()
                    }
                    val btn20 = dialogLayout.findViewById<Button>(R.id.btn_20)
                    btn20.setOnClickListener { _: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 20).toString()
                    }
                    val btn50 = dialogLayout.findViewById<Button>(R.id.btn_50)
                    btn50.setOnClickListener { _: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 50).toString()
                    }

                    val returnScore = view.findViewById<Button>(R.id.list_item_game_calcScoreBtn)
                    val positiveButtonClick = { _: DialogInterface, _: Int ->
                        returnScore.text = tvScore.text.toString()
                    }
                    builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
                    builder.setNegativeButton("Cancel", null)

                    builder.show()
                }


                return ViewHolder(binding)
            }
        }
    }
}
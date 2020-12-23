package com.grapevineindustries.scoretracker.adapters

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.grapevineindustries.scoretracker.Players
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.databinding.ListItemGameBinding

class GameAdapter(val players: Players): RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = players.size

    class ViewHolder (private val binding: ListItemGameBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
        }

        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemGameBinding.inflate(layoutInflater, parent, false)

                binding.listItemGameCalcScoreBtn.setOnClickListener { view: View ->
                    val builder = AlertDialog.Builder(parent.context)
                    val inflater = layoutInflater
                    val dialogLayout = inflater.inflate(R.layout.dialog_popup_calc, null)
                    builder.setView(dialogLayout)

                    val tvScore = dialogLayout.findViewById<TextView>(R.id.calcScore)

                    val btn3 = dialogLayout.findViewById<Button>(R.id.btn_3)
                    btn3.setOnClickListener { view: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 3).toString()
                    }
                    val btn4 = dialogLayout.findViewById<Button>(R.id.btn_4)
                    btn4.setOnClickListener { view: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 4).toString()
                    }
                    val btn5 = dialogLayout.findViewById<Button>(R.id.btn_5)
                    btn5.setOnClickListener { view: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 5).toString()
                    }
                    val btn6 = dialogLayout.findViewById<Button>(R.id.btn_6)
                    btn6.setOnClickListener { view: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 6).toString()
                    }
                    val btn7 = dialogLayout.findViewById<Button>(R.id.btn_7)
                    btn7.setOnClickListener { view: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 7).toString()
                    }
                    val btn8 = dialogLayout.findViewById<Button>(R.id.btn_8)
                    btn8.setOnClickListener { view: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 8).toString()
                    }
                    val btn9 = dialogLayout.findViewById<Button>(R.id.btn_9)
                    btn9.setOnClickListener { view: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 9).toString()
                    }
                    val btn10 = dialogLayout.findViewById<Button>(R.id.btn_10)
                    btn10.setOnClickListener { view: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 10).toString()
                    }
                    val btnJ = dialogLayout.findViewById<Button>(R.id.btn_j)
                    btnJ.setOnClickListener { view: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 11).toString()
                    }
                    val btnQ = dialogLayout.findViewById<Button>(R.id.btn_q)
                    btnQ.setOnClickListener { view: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 12).toString()
                    }
                    val btnK = dialogLayout.findViewById<Button>(R.id.btn_k)
                    btnK.setOnClickListener { view: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 13).toString()
                    }
                    val btn20 = dialogLayout.findViewById<Button>(R.id.btn_20)
                    btn20.setOnClickListener { view: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 20).toString()
                    }
                    val btn50 = dialogLayout.findViewById<Button>(R.id.btn_50)
                    btn50.setOnClickListener { view: View ->
                        tvScore.text = (tvScore.text.toString().toInt() + 50).toString()
                    }

                    val returnScore = view.findViewById<Button>(R.id.list_item_game_calcScoreBtn)
                    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
                        returnScore.text = tvScore.text.toString()
                    }
                    builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
                    builder.setNegativeButton(android.R.string.no, null)

                    builder.show()
                }


                return ViewHolder(binding)
            }
        }
    }
}
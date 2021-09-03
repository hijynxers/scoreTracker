package com.grapevineindustries.scoretracker.adapters

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.grapevineindustries.scoretracker.models.Player
import com.grapevineindustries.scoretracker.models.Players
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.databinding.ListItemGameBinding
import com.grapevineindustries.scoretracker.utilities.GLOBAL_DEALER_IDX
import com.grapevineindustries.scoretracker.utilities.GLOBAL_GAME_FIVE_CROWNS
import com.grapevineindustries.scoretracker.utilities.GLOBAL_GAME_RUMMY

open class GameAdapter(private val players: Players, val gameType: String): RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent, gameType)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(players[position], position, players.size)
    }

    override fun getItemCount() = players.size

    class ViewHolder (private val binding: ListItemGameBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(player: Player, position: Int, size: Int) {
            if (position == (GLOBAL_DEALER_IDX % size)) {
                binding.root.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.colorPrimaryLight))
            }
            binding.listItemGameName.text = player.name
        }

        companion object {
            private fun addScore(btn: Button, textView: TextView) {
                if (textView.text == "0")
                {
                    textView.text = ""
                }
                val text = textView.text.toString() + btn.text.toString()
                textView.text = text
            }

            fun from(parent: ViewGroup, gameType: String) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemGameBinding.inflate(layoutInflater, parent, false)

                if (gameType == GLOBAL_GAME_RUMMY)
                {
                    binding.listItemGameCalcScoreBtn.setOnClickListener { view: View ->
                        val builder = MaterialAlertDialogBuilder(parent.context, R.style.AlertDialogTheme_FiveCrowns)
                        val dialogLayout = layoutInflater.inflate(R.layout.dialog_popup_calc_subtract, null)
                        builder.setView(dialogLayout)

                        val tvScore = dialogLayout.findViewById<TextView>(R.id.calcScore)
                        val tvNegative = dialogLayout.findViewById<TextView>(R.id.calcScore_negative)

                        val btn1 = dialogLayout.findViewById<Button>(R.id.btn_calc_sub_1)
                        btn1.setOnClickListener { _: View ->
                            addScore(btn1, tvScore)
                        }
                        val btn2 = dialogLayout.findViewById<Button>(R.id.btn_calc_sub_2)
                        btn2.setOnClickListener { _: View ->
                            addScore(btn2, tvScore)
                        }
                        val btn3 = dialogLayout.findViewById<Button>(R.id.btn_calc_sub_3)
                        btn3.setOnClickListener { _: View ->
                            addScore(btn3, tvScore)
                        }
                        val btn4 = dialogLayout.findViewById<Button>(R.id.btn_calc_sub_4)
                        btn4.setOnClickListener { _: View ->
                            addScore(btn4, tvScore)
                        }
                        val btn5 = dialogLayout.findViewById<Button>(R.id.btn_calc_sub_5)
                        btn5.setOnClickListener { _: View ->
                            addScore(btn5, tvScore)
                        }
                        val btn6 = dialogLayout.findViewById<Button>(R.id.btn_calc_sub_6)
                        btn6.setOnClickListener { _: View ->
                            addScore(btn6, tvScore)
                        }
                        val btn7 = dialogLayout.findViewById<Button>(R.id.btn_calc_sub_7)
                        btn7.setOnClickListener { _: View ->
                            addScore(btn7, tvScore)
                        }
                        val btn8 = dialogLayout.findViewById<Button>(R.id.btn_calc_sub_8)
                        btn8.setOnClickListener { _: View ->
                            addScore(btn8, tvScore)
                        }
                        val btn9 = dialogLayout.findViewById<Button>(R.id.btn_calc_sub_9)
                        btn9.setOnClickListener { _: View ->
                            addScore(btn9, tvScore)
                        }
                        val btn0 = dialogLayout.findViewById<Button>(R.id.btn_calc_sub_0)
                        btn0.setOnClickListener { _: View ->
                            addScore(btn0, tvScore)
                        }
                        val btnSub = dialogLayout.findViewById<Button>(R.id.btn_calc_sub_sub)
                        btnSub.setOnClickListener { _: View ->
                            tvNegative.text = if (tvNegative.text.toString() == "-") {
                                ""
                            } else {
                                "-"
                            }
                        }

                        val returnScore = view.findViewById<Button>(R.id.list_item_game_calcScoreBtn)
                        val positiveButtonClick = { _: DialogInterface, _: Int ->
                            returnScore.text = if (tvNegative.text.toString() == "-")
                            {
                                "-" + tvScore.text.toString()
                            } else {
                                tvScore.text.toString()
                            }

                        }
                        builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
                        builder.setNegativeButton("Cancel", null)

                        builder.show()
                    }
                }
                else if (gameType == GLOBAL_GAME_FIVE_CROWNS)
                {
                    binding.listItemGameCalcScoreBtn.setOnClickListener { view: View ->
                        val builder = MaterialAlertDialogBuilder(parent.context, R.style.AlertDialogTheme_FiveCrowns)
                        val dialogLayout = layoutInflater.inflate(R.layout.dialog_popup_calc, null)
                        builder.setView(dialogLayout)

                        val tvScore = dialogLayout.findViewById<TextView>(R.id.calcScore)

                        val btn3 = dialogLayout.findViewById<Button>(R.id.btn_calc_3)
                        btn3.setOnClickListener { _: View ->
                            tvScore.text = (tvScore.text.toString().toInt() + 3).toString()
                        }
                        val btn4 = dialogLayout.findViewById<Button>(R.id.btn_calc_4)
                        btn4.setOnClickListener { _: View ->
                            tvScore.text = (tvScore.text.toString().toInt() + 4).toString()
                        }
                        val btn5 = dialogLayout.findViewById<Button>(R.id.btn_calc_5)
                        btn5.setOnClickListener { _: View ->
                            tvScore.text = (tvScore.text.toString().toInt() + 5).toString()
                        }
                        val btn6 = dialogLayout.findViewById<Button>(R.id.btn_calc_6)
                        btn6.setOnClickListener { _: View ->
                            tvScore.text = (tvScore.text.toString().toInt() + 6).toString()
                        }
                        val btn7 = dialogLayout.findViewById<Button>(R.id.btn_calc_7)
                        btn7.setOnClickListener { _: View ->
                            tvScore.text = (tvScore.text.toString().toInt() + 7).toString()
                        }
                        val btn8 = dialogLayout.findViewById<Button>(R.id.btn_calc_8)
                        btn8.setOnClickListener { _: View ->
                            tvScore.text = (tvScore.text.toString().toInt() + 8).toString()
                        }
                        val btn9 = dialogLayout.findViewById<Button>(R.id.btn_calc_9)
                        btn9.setOnClickListener { _: View ->
                            tvScore.text = (tvScore.text.toString().toInt() + 9).toString()
                        }
                        val btn10 = dialogLayout.findViewById<Button>(R.id.btn_calc_10)
                        btn10.setOnClickListener { _: View ->
                            tvScore.text = (tvScore.text.toString().toInt() + 10).toString()
                        }
                        val btnJ = dialogLayout.findViewById<Button>(R.id.btn_calc_j)
                        btnJ.setOnClickListener { _: View ->
                            tvScore.text = (tvScore.text.toString().toInt() + 11).toString()
                        }
                        val btnQ = dialogLayout.findViewById<Button>(R.id.btn_calc_q)
                        btnQ.setOnClickListener { _: View ->
                            tvScore.text = (tvScore.text.toString().toInt() + 12).toString()
                        }
                        val btnK = dialogLayout.findViewById<Button>(R.id.btn_calc_k)
                        btnK.setOnClickListener { _: View ->
                            tvScore.text = (tvScore.text.toString().toInt() + 13).toString()
                        }
                        val btn20 = dialogLayout.findViewById<Button>(R.id.btn_calc_20)
                        btn20.setOnClickListener { _: View ->
                            tvScore.text = (tvScore.text.toString().toInt() + 20).toString()
                        }
                        val btn50 = dialogLayout.findViewById<Button>(R.id.btn_calc_50)
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
                }




                return ViewHolder(binding)
            }
        }
    }
}
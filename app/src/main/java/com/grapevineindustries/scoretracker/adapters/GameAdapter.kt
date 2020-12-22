package com.grapevineindustries.scoretracker.adapters

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
                    //popupCalc(view, parent.context)
                }


                return ViewHolder(binding)
            }

            fun popupCalc(view: View, context: Context) {

//                val calcDialog = Dialog(context)
//                calcDialog.
//                calcDialog.setContentView(R.layout.dialog_popup_calc)
//                calcDialog.setTitle("Add Score:")
//
//                val btn3 = calcDialog.btn_3
//                val btn4 = calcDialog.btn_4
//                val btn5 = calcDialog.btn_5
//                val btn6 = calcDialog.btn_6
//                val btn7 = calcDialog.btn_7
//                val btn8 = calcDialog.btn_8
//                val btn9 = calcDialog.btn_9
//                val btn10 = calcDialog.btn_10
//                val btnJ = calcDialog.btn_j
//                val btnQ = calcDialog.btn_q
//                val btnK = calcDialog.btn_k
//                val btn20 = calcDialog.btn_20
//                val btn50 = calcDialog.btn_50
//                val btnDone = calcDialog.btn_done
//
//                btn3.setOnClickListener {
//
//                    calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 3).toString()
//                }
//                btn4.setOnClickListener {
//                    calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 4).toString()
//                }
//                btn5.setOnClickListener {
//                    calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 5).toString()
//                }
//                btn6.setOnClickListener {
//                    calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 6).toString()
//                }
//                btn7.setOnClickListener {
//                    calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 7).toString()
//                }
//                btn8.setOnClickListener {
//                    calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 8).toString()
//                }
//                btn9.setOnClickListener {
//                    calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 9).toString()
//                }
//                btn10.setOnClickListener {
//                    calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 10).toString()
//                }
//                btnJ.setOnClickListener {
//                    calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 11).toString()
//                }
//                btnQ.setOnClickListener {
//                    calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 12).toString()
//                }
//                btnK.setOnClickListener {
//                    calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 13).toString()
//                }
//                btn20.setOnClickListener {
//                    calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 20).toString()
//                }
//                btn50.setOnClickListener {
//                    calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 50).toString()
//                }
//                btnDone.setOnClickListener {
//                    view.computeScore_calcScoreBtn.text = calcDialog.calcScore.text.toString()
//                    calcDialog.dismiss()
//                }
//                calcDialog.show()
            }
        }


    }


}
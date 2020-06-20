package com.grapevineindustries.scoretracker.adapters

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.model.Player
import kotlinx.android.synthetic.main.dialog_popup_calc.*
import kotlinx.android.synthetic.main.list_item_compute_score.view.btn_calcScore

class ComputeScoreRecyclerAdapter(val context: Context, val players: ArrayList<Player>): RecyclerView.Adapter<ComputeScoreRecyclerAdapter.ComputeScoreHolder>() {

    inner class ComputeScoreHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView? = itemView.findViewById(R.id.tv_name)
        val score: TextView? = itemView.findViewById(R.id.tv_score)

        fun bindComputeScore(player: Player, context: Context) {
            name?.text = player.name
            score?.text = player.score.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComputeScoreHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_compute_score, parent, false)
        view.btn_calcScore.setOnClickListener{
            popupCalc(view)
        }
        return ComputeScoreHolder(view)
    }

    override fun getItemCount(): Int {
        return Integer.valueOf(players.count())
    }

    override fun onBindViewHolder(holder: ComputeScoreHolder, position: Int) {
        holder.bindComputeScore(players[position], context)
    }

    private fun popupCalc(view: View) {

        val calcDialog = Dialog(context)
        calcDialog.setContentView(R.layout.dialog_popup_calc)
        calcDialog.setTitle("Add Score:")

        val btn3 = calcDialog.btn_3
        val btn4 = calcDialog.btn_4
        val btn5 = calcDialog.btn_5
        val btn6 = calcDialog.btn_6
        val btn7 = calcDialog.btn_7
        val btn8 = calcDialog.btn_8
        val btn9 = calcDialog.btn_9
        val btn10 = calcDialog.btn_10
        val btnJ = calcDialog.btn_j
        val btnQ = calcDialog.btn_q
        val btnK = calcDialog.btn_k
        val btn20 = calcDialog.btn_20
        val btn50 = calcDialog.btn_50
        val btnDone = calcDialog.btn_done

        btn3.setOnClickListener {
            calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 3).toString()
        }
        btn4.setOnClickListener {
            calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 4).toString()
        }
        btn5.setOnClickListener {
            calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 5).toString()
        }
        btn6.setOnClickListener {
            calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 6).toString()
        }
        btn7.setOnClickListener {
            calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 7).toString()
        }
        btn8.setOnClickListener {
            calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 8).toString()
        }
        btn9.setOnClickListener {
            calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 9).toString()
        }
        btn10.setOnClickListener {
            calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 10).toString()
        }
        btnJ.setOnClickListener {
            calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 11).toString()
        }
        btnQ.setOnClickListener {
            calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 12).toString()
        }
        btnK.setOnClickListener {
            calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 13).toString()
        }
        btn20.setOnClickListener {
            calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 20).toString()
        }
        btn50.setOnClickListener {
            calcDialog.calcScore.text = (Integer.valueOf(calcDialog.calcScore.text.toString()) + 50).toString()
        }
        btnDone.setOnClickListener {
            view.btn_calcScore.text = calcDialog.calcScore.text.toString()
            calcDialog.dismiss()
        }
        calcDialog.show()
    }
}

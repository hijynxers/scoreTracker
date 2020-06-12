package com.grapevineindustries.scoretracker.controller

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import com.grapevineindustries.scoretracker.R
import kotlinx.android.synthetic.main.activity_popup_calc.*
import kotlinx.android.synthetic.main.activity_popup_calc.view.*
import kotlinx.android.synthetic.main.compute_score_list_item.*

class PopupCalcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_calc)

        btn_calcScore.setOnClickListener {
            popupCalc()
        }

        btn_3.setOnClickListener {view ->
            clicked3(view)
        }
    }

    private fun popupCalc() {
        val calcDialog = Dialog(this)
        calcDialog.setContentView(R.layout.activity_popup_calc)
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
            calcScore.text = (Integer.valueOf(calcScore.text.toString()) + 3).toString()
        }
        btnDone.setOnClickListener {
            btn_calcScore.text = calcScore.text.toString()
        }
        calcDialog.show()
    }

    fun add(lhs: Int, rhs: Int): String {
        return (lhs + rhs).toString()
    }

    fun clicked3(view: View) {
        //val n = Integer.valueOf(view.calcScore.text.toString())
        val n = 7
        val value: String = when(view) {
            view.btn_3 -> add(n, 3)
            view.btn_4 -> add(n, 4)
            view.btn_5 -> add(n, 5)
            view.btn_6 -> add(n, 6)
            view.btn_7 -> add(n, 7)
            view.btn_8 -> add(n, 8)
            view.btn_9 -> add(n, 9)
            view.btn_10 -> add(n, 10)
            view.btn_j -> add(n, 11)
            view.btn_q -> add(n, 12)
            view.btn_k -> add(n, 13)
            view.btn_20 -> add(n, 20)
            view.btn_50 -> add(n, 50)
            else -> add(n, 0)
        }
        view.calcScore.text = value
    }




}

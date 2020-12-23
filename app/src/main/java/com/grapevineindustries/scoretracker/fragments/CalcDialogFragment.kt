package com.grapevineindustries.scoretracker

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class CalcDialogFragment : DialogFragment() {

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            val view = inflater.inflate(R.layout.dialog_popup_calc, null)


            val tvScore = view.findViewById<TextView>(R.id.calcScore)




            val btn3 = view.findViewById<Button>(R.id.btn_3)
            btn3.setOnClickListener { view: View ->
                Toast.makeText(context, "nathan", Toast.LENGTH_SHORT).show()
                tvScore.text = (tvScore.text.toString().toInt() + 3).toString()
            }
            val btn4 = view.findViewById<Button>(R.id.btn_4)
            btn4.setOnClickListener { view: View ->
                Toast.makeText(context, "nathan", Toast.LENGTH_SHORT).show()
                tvScore.text = (tvScore.text.toString().toInt() + 4).toString()
            }
            val btn5 = view.findViewById<Button>(R.id.btn_5)
            btn5.setOnClickListener { view: View ->
                Toast.makeText(context, "nathan", Toast.LENGTH_SHORT).show()
                tvScore.text = (tvScore.text.toString().toInt() + 5).toString()
            }
            val btn6 = view.findViewById<Button>(R.id.btn_6)
            btn6.setOnClickListener { view: View ->
                Toast.makeText(context, "nathan", Toast.LENGTH_SHORT).show()
                tvScore.text = (tvScore.text.toString().toInt() + 6).toString()
            }
            val btn7 = view.findViewById<Button>(R.id.btn_7)
            btn7.setOnClickListener { view: View ->
                Toast.makeText(context, "nathan", Toast.LENGTH_SHORT).show()
                tvScore.text = (tvScore.text.toString().toInt() + 7).toString()
            }
            val btn8 = view.findViewById<Button>(R.id.btn_8)
            btn8.setOnClickListener { view: View ->
                Toast.makeText(context, "nathan", Toast.LENGTH_SHORT).show()
                tvScore.text = (tvScore.text.toString().toInt() + 8).toString()
            }
            val btn9 = view.findViewById<Button>(R.id.btn_9)
            btn9.setOnClickListener { view: View ->
                Toast.makeText(context, "nathan", Toast.LENGTH_SHORT).show()
                tvScore.text = (tvScore.text.toString().toInt() + 9).toString()
            }
            val btn10 = view.findViewById<Button>(R.id.btn_10)
            btn10.setOnClickListener { view: View ->
                Toast.makeText(context, "nathan", Toast.LENGTH_SHORT).show()
                tvScore.text = (tvScore.text.toString().toInt() + 10).toString()
            }
            val btnJ = view.findViewById<Button>(R.id.btn_j)
            btnJ.setOnClickListener { view: View ->
                Toast.makeText(context, "nathan", Toast.LENGTH_SHORT).show()
                tvScore.text = (tvScore.text.toString().toInt() + 11).toString()
            }
            val btnQ = view.findViewById<Button>(R.id.btn_q)
            btnQ.setOnClickListener { view: View ->
                Toast.makeText(context, "nathan", Toast.LENGTH_SHORT).show()
                tvScore.text = (tvScore.text.toString().toInt() + 12).toString()
            }
            val btnK = view.findViewById<Button>(R.id.btn_k)
            btnK.setOnClickListener { view: View ->
                Toast.makeText(context, "nathan", Toast.LENGTH_SHORT).show()
                tvScore.text = (tvScore.text.toString().toInt() + 13).toString()
            }
            val btn20 = view.findViewById<Button>(R.id.btn_20)
            btn20.setOnClickListener { view: View ->
                Toast.makeText(context, "nathan", Toast.LENGTH_SHORT).show()
                tvScore.text = (tvScore.text.toString().toInt() + 20).toString()
            }
            val btn50 = view.findViewById<Button>(R.id.btn_50)
            btn50.setOnClickListener { view: View ->
                Toast.makeText(context, "nathan", Toast.LENGTH_SHORT).show()
                tvScore.text = (tvScore.text.toString().toInt() + 50).toString()
            }

            val btnDone = view.findViewById<Button>(R.id.btn_done)
            btnDone.setOnClickListener { view: View ->
                view.computeScore_calcScoreBtn.text = calcDialog.calcScore.text.toString()
            }
            
            builder.setView(view)



//            builder.setMessage(R.string.dialog_fire_missiles)
//                .setPositiveButton(R.string.fire,
//                    DialogInterface.OnClickListener { dialog, id ->
//                        // FIRE ZE MISSILES!
//                    })
//                .setNegativeButton(R.string.cancel,
//                    DialogInterface.OnClickListener { dialog, id ->
//                        // User cancelled the dialog
//                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}
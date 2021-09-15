package com.grapevineindustries.scoretracker.fragments

import android.content.ContentValues.TAG
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.databinding.FragmentGameBinding
import com.grapevineindustries.scoretracker.gameLogic.*
import com.grapevineindustries.scoretracker.utilities.*

class GameFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater, R.layout.fragment_game, container, false)
        val args = GameFragmentArgs.fromBundle(requireArguments())
        val playerList = args.playerList

        when (val gameType = args.gameType) {
            GLOBAL_GAME_FIVE_CROWNS -> {
                val fiveCrowns = FiveCrowns()
                fiveCrowns.play(binding, playerList, activity, context, gameType)
            }
            GLOBAL_GAME_RUMMY -> {
                val rummy = Rummy()
                rummy.play(binding, playerList, activity, context, gameType)
            }
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        requireActivity().onBackPressedDispatcher.addCallback(
                this,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        val builder = context?.let { MaterialAlertDialogBuilder(it, R.style.AlertDialogTheme_FiveCrowns) }

                        val positiveButtonClick = { _: DialogInterface, _: Int ->
                            // if you want onBackPressed() to be called as normal afterwards
                            if (isEnabled) {
                                isEnabled = false
                                requireActivity().onBackPressed()
                            }
                        }

                        builder?.setMessage("Do you want to quit?")
                        builder?.setPositiveButton("Quit", DialogInterface.OnClickListener(function = positiveButtonClick))
                        builder?.setNegativeButton("Return", null)
                        builder?.show()
                    }
                }
        )
    }
}


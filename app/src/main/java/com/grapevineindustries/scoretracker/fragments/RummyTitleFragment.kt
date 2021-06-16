package com.grapevineindustries.scoretracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.databinding.FragmentAddPlayersBinding
import com.grapevineindustries.scoretracker.databinding.FragmentTitlePageBinding


class RummyTitleFragment : Fragment() {

    private var numPlayers = 2

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitlePageBinding>(inflater, R.layout.fragment_title_page, container, false)

        binding.startTitle.text = "Rummy"

        binding.tvNumPlayers.text = numPlayers.toString()


        binding.btnStart.setOnClickListener { view : View ->
            view.findNavController().navigate(RummyTitleFragmentDirections.actionTitleFragmentToAddPlayersFragment23(numPlayers))
        }

        binding.btnPlus.setOnClickListener { view : View ->
            if(numPlayers != 6) {
                numPlayers++
                binding.tvNumPlayers.text = numPlayers.toString()
            }
        }

        binding.btnMinus.setOnClickListener { view : View ->
            if(numPlayers != 2) {
                numPlayers--
                binding.tvNumPlayers.text = numPlayers.toString()
            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}
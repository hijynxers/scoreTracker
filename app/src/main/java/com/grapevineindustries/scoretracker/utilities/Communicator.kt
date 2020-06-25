package com.grapevineindustries.scoretracker.utilities

import com.grapevineindustries.scoretracker.model.Player

interface Communicator {
    fun startDisplayFrag(wildcard: String, players: ArrayList<Player>)
    fun startComputeFrag(wildcard: String, players: ArrayList<Player>)
}
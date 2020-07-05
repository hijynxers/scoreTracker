package com.grapevineindustries.scoretracker.utilities

import com.grapevineindustries.scoretracker.model.Player

interface Communicator {
    fun startDisplayFrag(wildcard: Int, players: ArrayList<Player>)
    fun startComputeFrag(wildcard: Int, players: ArrayList<Player>)
}
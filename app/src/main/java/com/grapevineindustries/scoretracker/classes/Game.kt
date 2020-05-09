
package com.grapevineindustries.scoretracker.classes

class Game(name: String, rounds: Int) {
    private var players: ArrayList<Player> = ArrayList()

    fun AddPlayer(player: Player) {
        this.players.add(player)
    }

    fun SetPlayers(players: ArrayList<Player>) {
        this.players = players
    }
}
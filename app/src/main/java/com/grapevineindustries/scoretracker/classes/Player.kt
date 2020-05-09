package com.grapevineindustries.scoretracker.classes

class Player(name: String) {
    private var score: Int = 0

    fun AddScore(s: Int) {
        score += s
    }
}
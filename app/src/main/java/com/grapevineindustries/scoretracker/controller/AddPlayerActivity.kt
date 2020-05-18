package com.grapevineindustries.scoretracker.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.adapters.AddPlayerRecyclerAdapter
import com.grapevineindustries.scoretracker.model.Player
import com.grapevineindustries.scoretracker.utilities.EXTRA_NUM_PLAYERS
import kotlinx.android.synthetic.main.activity_add_player.*
import kotlinx.android.synthetic.main.add_player_list_item.view.*

class AddPlayerActivity : AppCompatActivity() {

    lateinit var adapter: AddPlayerRecyclerAdapter
    lateinit var numPlayers: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_player)

        numPlayers = intent.getStringExtra(EXTRA_NUM_PLAYERS)
        adapter = AddPlayerRecyclerAdapter(this, numPlayers)

        rv_addPlayer.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        rv_addPlayer.layoutManager = layoutManager
    }

    fun onStartGameClick(view: View) {
        val namesList = arrayListOf<String>()
        val idx = Integer.valueOf(numPlayers) - 1
        for (num in 0..idx) {
            val a = rv_addPlayer.getChildAt(num)
            val name = a.editText.text.toString()
            namesList.add(name)
        }
        val playerList = createPlayers(namesList, idx)
        println(playerList)
    }

    fun createPlayers(names: List<String>, num: Int): List<Player> {
        val playerList = arrayListOf<Player>()
        for (i in 0..num) {
            playerList.add(Player(names[i]))
        }
        return playerList
    }
}

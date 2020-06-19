package com.grapevineindustries.scoretracker.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.grapevineindustries.scoretracker.R
import com.grapevineindustries.scoretracker.adapters.AddPlayerRecyclerAdapter
import com.grapevineindustries.scoretracker.model.Player
import com.grapevineindustries.scoretracker.utilities.EXTRA_NUM_PLAYERS
import kotlinx.android.synthetic.main.activity_add_player.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_add_player.view.*

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

    fun onStartGameClicked(view: View) {
        val namesList = arrayListOf<String>()
        val idx = Integer.valueOf(numPlayers) - 1
        for (num in 0..idx) {
            val a = rv_addPlayer.getChildAt(num)
            val name = a.editText.text.toString()
            namesList.add(name)
        }
        val playerList = createPlayers(namesList, idx)
        println(playerList)

        val addPlayerIntent = Intent(this, ComputeScoreActivity::class.java)
        addPlayerIntent.putParcelableArrayListExtra(EXTRA_NUM_PLAYERS, playerList)
        startActivity(addPlayerIntent)
    }

    fun createPlayers(names: List<String>, num: Int): ArrayList<Player> {
        val playerList = arrayListOf<Player>()
        for (i in 0..num) {
            playerList.add(Player(names[i]))
        }
        return playerList
    }
}

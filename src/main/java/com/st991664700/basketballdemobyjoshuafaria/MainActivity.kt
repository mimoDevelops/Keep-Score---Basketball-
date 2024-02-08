package com.st991664700.basketballdemobyjoshuafaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.st991664700.basketballdemobyjoshuafaria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val scoreModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the Toolbar to act as the ActionBar for this Activity window
        setSupportActionBar(binding.toolbar)

        // Initialize the scores for Team A and Team B
        displayForTeamA(scoreModel.scoreTeamA)
        displayForTeamB(scoreModel.scoreTeamB)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_new_game -> {
                // Handle "New Game" menu item click
                resetScore(null)
                return true
            }
            R.id.menu_exit -> {
                // Handle "Exit" menu item click
                showExitConfirmationDialog()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    private fun showExitConfirmationDialog() {
        AlertDialog.Builder(this)
            .setMessage("Are you sure you want to exit?")
            .setPositiveButton("Yes") { _, _ -> finish() }
            .setNegativeButton("No", null)
            .show()
    }

    fun addOneForTeamA(v: View?) {
        scoreModel.scoreTeamA++
        displayForTeamA(scoreModel.scoreTeamA)
    }

    fun addTwoForTeamA(v: View?) {
        scoreModel.scoreTeamA += 2
        displayForTeamA(scoreModel.scoreTeamA)
    }

    fun addThreeForTeamA(v: View?) {
        scoreModel.scoreTeamA += 3
        displayForTeamA(scoreModel.scoreTeamA)
    }

    private fun displayForTeamA(score: Int) {
        binding.teamAScore.text = score.toString()
    }

    fun addOneForTeamB(v: View?) {
        scoreModel.scoreTeamB++
        displayForTeamB(scoreModel.scoreTeamB)
    }

    fun addTwoForTeamB(v: View?) {
        scoreModel.scoreTeamB += 2
        displayForTeamB(scoreModel.scoreTeamB)
    }

    fun addThreeForTeamB(v: View?) {
        scoreModel.scoreTeamB += 3
        displayForTeamB(scoreModel.scoreTeamB)
    }

    private fun displayForTeamB(score: Int) {
        binding.teamBScore.text = score.toString()
    }

    fun resetScore(v: View?) {
        scoreModel.scoreTeamA = 0
        scoreModel.scoreTeamB = 0
        displayForTeamA(scoreModel.scoreTeamA)
        displayForTeamB(scoreModel.scoreTeamB)
    }
}

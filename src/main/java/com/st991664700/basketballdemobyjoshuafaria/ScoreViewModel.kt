package com.st991664700.basketballdemobyjoshuafaria

import android.view.View
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class ScoreViewModel(private val state: SavedStateHandle) : ViewModel() {



    companion object {
        private const val SCORE_TEAM_A_KEY = "score_team_a"
        private const val SCORE_TEAM_B_KEY = "score_team_b"
    }

    // Get the scores from SavedStateHandle or set default value if null
    var scoreTeamA: Int
        get() = state.get(SCORE_TEAM_A_KEY) ?: 0
        set(value) = state.set(SCORE_TEAM_A_KEY, value)

    var scoreTeamB: Int
        get() = state.get(SCORE_TEAM_B_KEY) ?: 0
        set(value) = state.set(SCORE_TEAM_B_KEY, value)
}

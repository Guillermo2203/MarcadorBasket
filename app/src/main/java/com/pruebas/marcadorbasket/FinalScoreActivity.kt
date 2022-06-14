package com.pruebas.marcadorbasket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pruebas.marcadorbasket.databinding.ActivityFinalScoreBinding

class FinalScoreActivity : AppCompatActivity() {
    companion object{
        const val LOCAL_SCORE_KEY = "finalLocalScore"
        const val VISITOR_SCORE_KEY = "finalVisitorScore"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFinalScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val localScore = intent.extras!!.getInt(LOCAL_SCORE_KEY)
        val visitorScore = intent.extras!!.getInt(VISITOR_SCORE_KEY)
        binding.localScoreText.text = localScore.toString()
        binding.visitorScoreText.text = visitorScore.toString()


        when {
            localScore > visitorScore -> binding.winnerText.text = getString(R.string.local_wins)
            localScore < visitorScore -> binding.winnerText.text = getString(R.string.visitor_wins)
            else -> binding.winnerText.text = getString(R.string.tie)
        }
    }
}
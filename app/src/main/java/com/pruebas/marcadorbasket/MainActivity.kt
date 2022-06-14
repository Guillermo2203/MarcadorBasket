package com.pruebas.marcadorbasket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pruebas.marcadorbasket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.mainViewModel = viewModel

        viewModel.localScoreLiveData.observe(this, Observer{
            localScoreValue ->
            binding.localScoreText.text = localScoreValue.toString()
        })
        viewModel.visitorScoreLiveData.observe(this, Observer{
                visitorScoreValue ->
            binding.visitorScoreText.text = visitorScoreValue.toString()
        })

        setUpButtons()
    }

    private fun setUpButtons() {
        binding.finalScoreButton.setOnClickListener {
            openFinalScoreActivity()
        }
    }

    private fun openFinalScoreActivity() {
        val intent = Intent(this, FinalScoreActivity::class.java)
        intent.putExtra(FinalScoreActivity.VISITOR_SCORE_KEY, viewModel.visitorScoreLiveData.value)
        intent.putExtra(FinalScoreActivity.LOCAL_SCORE_KEY, viewModel.localScoreLiveData.value)
        startActivity(intent)
    }
}
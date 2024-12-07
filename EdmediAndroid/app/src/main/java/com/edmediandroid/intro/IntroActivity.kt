package com.edmediandroid.intro

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.edmediandroid.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroBinding
    private val viewModel: IntroViewModel by viewModels {
        IntroViewModelFactory(IntroRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            viewModel.login()
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.loginResult.observe(this) { result ->
            result.onSuccess { token ->

            }.onFailure { error ->
                Toast.makeText(this, "Login Error: ${error.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}
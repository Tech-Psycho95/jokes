package com.sidharth.jokes.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.sidharth.jokes.databinding.ActivityMainBinding
import com.sidharth.jokes.presentation.viewmodel.JokesViewModel
import com.sidharth.jokes.presentation.viewmodel.JokesViewModelFactory
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: JokesViewModel by viewModels { JokesViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        initializeView()
        collectFlows()
    }

    private fun initializeView() {
        viewModel.fetchJokes()
        viewModel.fetchJoke()
        viewBinding.btnToggle.setOnClickListener {
            viewModel.toggleButton()
        }
    }

    private fun collectFlows() {
        lifecycleScope.launch {
        repeatOnLifecycle(
            Lifecycle.State.STARTED,
        ) {
            viewModel.shouldShowSingleJoke.collectLatest { showSingle ->
                viewBinding.apply {
                    rvJokes.isVisible = !showSingle
                    tvJoke.isVisible = showSingle
                }
                viewBinding.btnToggle.text = "Show List".takeIf { showSingle } ?: "Show Single"
            }

            viewModel.joke.collectLatest { joke ->
                Log.d("thisisajoke", "$joke")
                joke?.let {
                    viewBinding.tvJoke.text = it.data.joinToString { it1 -> "$it1\n" }
                }
            }

            viewModel.jokes.collectLatest {

            }
        }
        }
    }
}
package at.sunilson.example4

import android.os.Bundle
import android.transition.TransitionManager
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import at.sunilson.example4.databinding.ActivityExample4Binding
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform

class Example4Activity : AppCompatActivity() {

    private var searchMode = false
    private var _binding: ActivityExample4Binding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityExample4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.searchBar.setOnClickListener {
            val transform = MaterialContainerTransform().apply {
                startView = binding.searchBar
                endView = binding.searchView
                pathMotion = MaterialArcMotion()
            }
            TransitionManager.beginDelayedTransition(binding.fragmentContainer, transform)
            binding.searchBar.visibility = View.GONE
            binding.searchView.visibility = View.VISIBLE
            searchMode = true
        }
    }

    override fun onBackPressed() {
        if (searchMode) {
            searchMode = false
            val transform = MaterialContainerTransform().apply {
                startView = binding.searchView
                endView = binding.searchBar
                pathMotion = MaterialArcMotion()
            }
            TransitionManager.beginDelayedTransition(binding.fragmentContainer, transform)
            binding.searchBar.visibility = View.VISIBLE
            binding.searchView.visibility = View.GONE
            searchMode = true
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
package at.sunilson.materialmotiondemo.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import at.sunilson.example1.Example1Activity
import at.sunilson.example2.Example2Activity
import at.sunilson.example3.Example3Activity
import at.sunilson.materialmotiondemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.containerTransform1.setOnClickListener {
            startActivity(Intent(this, Example1Activity::class.java))
        }

        binding.containerTransform2.setOnClickListener {
            startActivity(Intent(this, Example2Activity::class.java))
        }

        binding.sharedAxis1.setOnClickListener {
            startActivity(Intent(this, Example3Activity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

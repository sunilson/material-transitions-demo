package at.sunilson.example2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import at.sunilson.example2.databinding.Example2Fragment1Binding
import com.google.android.material.transition.Hold

class Fragment1 : Fragment() {

    private var _binding: Example2Fragment1Binding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        Example2Fragment1Binding.inflate(inflater, container, false).run {
            _binding = this
            binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                // Map the start View in FragmentA and the transitionName of the end View in FragmentB
                .addSharedElement(binding.fab, "shared_element_container")
                .replace(R.id.fragment_container, Fragment2(), Fragment2.TAG)
                .addToBackStack(Fragment2.TAG)
                .commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exitTransition = Hold()
    }

    companion object {
        const val TAG = "fragment1"
    }
}
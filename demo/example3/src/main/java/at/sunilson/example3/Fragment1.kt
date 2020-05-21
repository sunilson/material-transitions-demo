package at.sunilson.example3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.fragment.app.Fragment
import at.sunilson.example3.databinding.Example3Fragment1Binding
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialSharedAxis
import kotlinx.android.synthetic.main.example_3_fragment_1.*

class Fragment1 : Fragment() {
    private var _binding: Example3Fragment1Binding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        Example3Fragment1Binding.inflate(inflater, container, false).run {
            _binding = this
            binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        items_container.children.forEach { child ->
            child.setOnClickListener {
                requireActivity()
                    .supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, Fragment2(), Fragment2.TAG)
                    .addToBackStack(Fragment2.TAG)
                    .commit()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reenterTransition = MaterialSharedAxis.create(MaterialSharedAxis.Z, false)
        exitTransition = MaterialSharedAxis.create(MaterialSharedAxis.Z, true)
    }
}
package at.sunilson.example3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import at.sunilson.example3.databinding.Example3Fragment2Binding
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialSharedAxis

class Fragment2 : Fragment() {

    private var _binding: Example3Fragment2Binding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        Example3Fragment2Binding.inflate(inflater, container, false).run {
            _binding = this
            binding.root
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialSharedAxis.create(MaterialSharedAxis.Z, true)
        returnTransition = MaterialSharedAxis.create(MaterialSharedAxis.Z, false)
    }


    companion object {
        const val TAG = "fragment2"
    }
}
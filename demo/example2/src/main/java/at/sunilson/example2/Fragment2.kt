package at.sunilson.example2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.fragment.app.Fragment
import at.sunilson.example2.databinding.Example2Fragment2Binding
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform

class Fragment2 : Fragment() {

    private var _binding: Example2Fragment2Binding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        Example2Fragment2Binding.inflate(inflater, container, false).run {
            _binding = this
            binding.root
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            interpolator = AccelerateDecelerateInterpolator()
            pathMotion = MaterialArcMotion()
        }
    }


    companion object {
        const val TAG = "fragment2"
    }
}
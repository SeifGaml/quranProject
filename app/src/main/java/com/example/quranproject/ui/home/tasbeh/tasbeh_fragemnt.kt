package com.example.quranproject.ui.home.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quranproject.databinding.FragmentTasbehBinding

class TasbehFragment : Fragment() {
    lateinit var viewBinding: FragmentTasbehBinding
    private var counter: Int = 0 // Variable to hold the counter value

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentTasbehBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set the initial counter value
        viewBinding.tvCounter.text = counter.toString()

        // Increment button click
        viewBinding.btnIncrement.setOnClickListener {
            counter++ // Increment the counter
            updateCounterDisplay()
        }

        // Reset button click
        viewBinding.btnReset.setOnClickListener {
            counter = 0 // Reset the counter
            updateCounterDisplay()
        }
    }

    // Function to update the counter display
    private fun updateCounterDisplay() {
        viewBinding.tvCounter.text = counter.toString()
    }
}

package com.example.famouspersonality.view.fragments.anantlaxman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.famouspersonality.R
import com.example.famouspersonality.databinding.FragmentAnantBottomSecondBinding

class AnantBottomSecondFragment : Fragment() {

    private lateinit var binding: FragmentAnantBottomSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnantBottomSecondBinding.inflate(layoutInflater)

        binding.readMore.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayoutContainer, AnantRevolutionaryFragment())
                .commit()
        }

        return binding.root
    }

}
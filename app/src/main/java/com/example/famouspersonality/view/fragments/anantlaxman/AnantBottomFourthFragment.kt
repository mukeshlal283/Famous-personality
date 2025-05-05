package com.example.famouspersonality.view.fragments.anantlaxman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.famouspersonality.R
import com.example.famouspersonality.databinding.FragmentAnantBottomFourthBinding

class AnantBottomFourthFragment : Fragment() {

    private lateinit var binding: FragmentAnantBottomFourthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAnantBottomFourthBinding.inflate(layoutInflater)

        binding.readMore.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayoutContainer, AnantSymbolOfYouthFragment())
                .commit()
        }

        return binding.root
    }

}
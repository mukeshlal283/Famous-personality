package com.example.famouspersonality.view.fragments.anantlaxman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.famouspersonality.R
import com.example.famouspersonality.databinding.FragmentAnantHomeBinding

class AnantHomeFragment : Fragment() {

    private lateinit var binding: FragmentAnantHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAnantHomeBinding.inflate(layoutInflater)

        binding.readMore.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayoutContainer, AnantIntroFragment())
                .commit()
        }

        // Inflate the layout for this fragment
        return binding.root
    }




}
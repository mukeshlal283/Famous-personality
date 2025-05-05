package com.example.famouspersonality.view.fragments.anantlaxman

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.famouspersonality.R
import com.example.famouspersonality.databinding.FragmentAnantBottomThirdBinding

class AnantBottomThirdFragment : Fragment() {

    private lateinit var binding: FragmentAnantBottomThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAnantBottomThirdBinding.inflate(layoutInflater)

        binding.readMore.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayoutContainer, AnantAMTJacksonFragment())
                .commit()
        }

        return binding.root
    }

}
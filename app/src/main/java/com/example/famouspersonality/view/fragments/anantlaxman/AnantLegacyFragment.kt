package com.example.famouspersonality.view.fragments.anantlaxman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import com.example.famouspersonality.R
import com.example.famouspersonality.databinding.FragmentAnantLegacyBinding
import com.example.famouspersonality.databinding.FragmentAnantMediaAndPublicBinding

class AnantLegacyFragment : Fragment() {

    private lateinit var binding: FragmentAnantLegacyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAnantLegacyBinding.inflate(layoutInflater)

        binding.scrollView.post {
            binding.scrollView.fullScroll(ScrollView.FOCUS_UP)
        }

        binding.backBtn.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayoutContainer, AnantHomeFragment())
                .commit()
        }

        return binding.root

    }


}
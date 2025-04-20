package com.example.famouspersonality.view.fragments.anantlaxman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import com.example.famouspersonality.R
import com.example.famouspersonality.databinding.FragmentAnantAMTJacksonBinding

class AnantAMTJacksonFragment : Fragment() {

    private lateinit var binding: FragmentAnantAMTJacksonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAnantAMTJacksonBinding.inflate(layoutInflater)

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
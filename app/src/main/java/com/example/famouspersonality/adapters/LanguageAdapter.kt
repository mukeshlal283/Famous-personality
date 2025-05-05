package com.example.famouspersonality.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.famouspersonality.databinding.LanguageSelectItemBinding
import com.example.famouspersonality.models.Language

class LanguageAdapter(val languageList: ArrayList<Language>, val viewPager: ViewPager2, val openActivity: (Bundle) -> Unit): RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    class LanguageViewHolder(val binding: LanguageSelectItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        return LanguageViewHolder(LanguageSelectItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val data = languageList[position]

        holder.binding.apply {
            firstName.text = data.firstName
            lastName.text = data.lastName
            languageButton.text = data.buttonText
        }

        if(position == languageList.size-1) {
            viewPager.post(runnable)
        }

        holder.binding.languageButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("lCode", data.languageCode)
            openActivity(bundle)
        }

    }

    private val runnable = Runnable {
        languageList.addAll(languageList)
        notifyDataSetChanged()
    }

}
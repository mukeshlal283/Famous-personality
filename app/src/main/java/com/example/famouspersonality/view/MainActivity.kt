package com.example.famouspersonality.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.famouspersonality.adapters.LanguageAdapter
import com.example.famouspersonality.databinding.ActivityMainBinding
import com.example.famouspersonality.models.Language

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: LanguageAdapter
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val languageList = ArrayList<Language>()
        languageList.add(Language("अनंत","लक्ष्मण कन्हेरे", "हिन्दी", "hi"))
        languageList.add(Language("अनंत","लक्ष्मण कन्हेरे", "मराठी", "mr"))
        languageList.add(Language("ANANT","LAKSHMAN KANHERE", "ENGLISH", "en"))

        adapter = LanguageAdapter(languageList, binding.viewPager, ::openActivity)

        binding.viewPager.adapter = adapter

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position) //we got position of selected item here
                handler.removeCallbacks(runnable) //if page is selected remove this callback on runnable
                handler.postDelayed(runnable, 2000)
            }
        })

    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 2000)
    }

    private val runnable = Runnable {
        binding.viewPager.currentItem = binding.viewPager.currentItem + 1 // we just increment current item
    }


    private fun openActivity(bundle: Bundle) {
        val intent = Intent(this, AnantLaxmanActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
        finish()
    }
}
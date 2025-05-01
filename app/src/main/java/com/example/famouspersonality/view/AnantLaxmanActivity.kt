package com.example.famouspersonality.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.famouspersonality.R
import com.example.famouspersonality.adapters.DrawerMenuAdapter
import com.example.famouspersonality.databinding.ActivityAnantLaxmanBinding
import com.example.famouspersonality.models.ChildMenu
import com.example.famouspersonality.models.DrawerMenuItem
import com.example.famouspersonality.view.fragments.anantlaxman.AnantAMTJacksonFragment
import com.example.famouspersonality.view.fragments.anantlaxman.AnantArrestTrial
import com.example.famouspersonality.view.fragments.anantlaxman.AnantAssassinationFragment
import com.example.famouspersonality.view.fragments.anantlaxman.AnantBottomFifthFragment
import com.example.famouspersonality.view.fragments.anantlaxman.AnantBottomFourthFragment
import com.example.famouspersonality.view.fragments.anantlaxman.AnantBottomSecondFragment
import com.example.famouspersonality.view.fragments.anantlaxman.AnantBottomThirdFragment
import com.example.famouspersonality.view.fragments.anantlaxman.AnantBritishResponseFragment
import com.example.famouspersonality.view.fragments.anantlaxman.AnantEarlyLifeFragment
import com.example.famouspersonality.view.fragments.anantlaxman.AnantHomeFragment
import com.example.famouspersonality.view.fragments.anantlaxman.AnantIdeologicalBeliefFragment
import com.example.famouspersonality.view.fragments.anantlaxman.AnantImpactRevolutionaryFragment
import com.example.famouspersonality.view.fragments.anantlaxman.AnantIntroFragment
import com.example.famouspersonality.view.fragments.anantlaxman.AnantLegacyFragment
import com.example.famouspersonality.view.fragments.anantlaxman.AnantMediaAndPublicFragment
import com.example.famouspersonality.view.fragments.anantlaxman.AnantPsycologocalFragment
import com.example.famouspersonality.view.fragments.anantlaxman.AnantRadicalRevolutionaryVisionFragment
import com.example.famouspersonality.view.fragments.anantlaxman.AnantRevolutionaryFragment
import com.example.famouspersonality.view.fragments.anantlaxman.AnantSymbolOfYouthFragment
import java.util.Locale

class AnantLaxmanActivity : BaseActivity() {

    private lateinit var binding: ActivityAnantLaxmanBinding
    private lateinit var menuButton: ImageButton
    private lateinit var closeButton: ImageButton
    private lateinit var adapter: DrawerMenuAdapter
    private lateinit var currentFragment: Fragment
    private lateinit var btnEnglish: Button
    private lateinit var btnHindi: Button
    private lateinit var btnMarathi: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnantLaxmanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeFragment(AnantHomeFragment())

        btnEnglish = findViewById(R.id.btnEnglish)
        btnHindi = findViewById(R.id.btnHindi)
        btnMarathi = findViewById(R.id.btnMarathi)

        val currentLang = Locale.getDefault().language
        updateLanguageButtons(currentLang)

        btnHindi.setOnClickListener {
            setLocale("hi")
        }

        btnEnglish.setOnClickListener {
            setLocale("en")
        }

        btnMarathi.setOnClickListener {
            setLocale("mr")
        }

        openAndCloseDrawer()

        val menuItemList = mutableListOf<Any> ()
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_1), AnantIntroFragment()))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_2), AnantEarlyLifeFragment()))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_3), AnantRevolutionaryFragment()))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_4,), null, true, listOf(ChildMenu(getString(R.string.anant_drawer_4_1), AnantAMTJacksonFragment()), ChildMenu(getString(R.string.anant_drawer_4_2), AnantAssassinationFragment()), ChildMenu(getString(R.string.anant_drawer_4_5), AnantArrestTrial()), ChildMenu(getString(R.string.anant_drawer_4_3), AnantMediaAndPublicFragment()), ChildMenu(getString(R.string.anant_drawer_4_4), AnantImpactRevolutionaryFragment()))))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_5), AnantSymbolOfYouthFragment()))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_6), AnantIdeologicalBeliefFragment()))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_7), AnantBritishResponseFragment()))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_8), AnantPsycologocalFragment()))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_9), AnantLegacyFragment()))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_10), AnantRadicalRevolutionaryVisionFragment()))

        adapter = DrawerMenuAdapter(menuItemList, ::changeFragment)

        binding.drawerRecyclerView.adapter = adapter

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.bottm_nav1 -> changeFragment(AnantHomeFragment())
                R.id.bottm_nav2 -> changeFragment(AnantBottomSecondFragment())
                R.id.bottm_nav3 -> changeFragment(AnantBottomThirdFragment())
                R.id.bottm_nav4 -> changeFragment(AnantBottomFourthFragment())
                R.id.bottm_nav5 -> changeFragment(AnantBottomFifthFragment())

                else -> {}
            }
            true
        }

//        NavigationUI.setupWithNavController(binding.bottomNavigationView,
//            Navigation.findNavController(this, R.id.frameLayoutContainer)
//        )

//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.frameLayoutContainer, AnantHomeFragment())
//                .commit()
//        }

    }

    private fun openAndCloseDrawer() {

        menuButton = findViewById(R.id.drawer_menu)
        closeButton = findViewById(R.id.drawerCloseBtn)

        menuButton.setOnClickListener {
            binding.drawer.openDrawer(GravityCompat.START)
        }
        closeButton.setOnClickListener {
            binding.drawer.closeDrawer(GravityCompat.START)
        }

    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayoutContainer, fragment)
            .commit()

        binding.drawer.closeDrawer(GravityCompat.START)
    }


    override fun onBackPressed() {

        currentFragment = supportFragmentManager.findFragmentById(R.id.frameLayoutContainer)!!

        if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
            binding.drawer.closeDrawer(GravityCompat.START)
        } else if (currentFragment != AnantHomeFragment()) {
            changeFragment(AnantHomeFragment())
        } else {
            super.onBackPressed()
        }

    }

    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)

        recreate()
    }

    private fun updateLanguageButtons(currentLang: String) {
        val btnEnglish = findViewById<Button>(R.id.btnEnglish)
        val btnHindi = findViewById<Button>(R.id.btnHindi)
        val btnMarathi = findViewById<Button>(R.id.btnMarathi)

        // Show all initially
        btnEnglish.visibility = View.VISIBLE
        btnHindi.visibility = View.VISIBLE
        btnMarathi.visibility = View.VISIBLE

        // Hide the current language button
        when (currentLang) {
            "en" -> btnEnglish.visibility = View.GONE
            "hi" -> btnHindi.visibility = View.GONE
            "mr" -> btnMarathi.visibility = View.GONE
        }
    }



}
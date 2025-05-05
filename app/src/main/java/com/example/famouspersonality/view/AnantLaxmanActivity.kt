package com.example.famouspersonality.view

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.viewModels
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.navArgument
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
import com.example.famouspersonality.viewmodel.MyViewModel
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
    private val viewModel: MyViewModel by viewModels()
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnantLaxmanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("fragment_prefs", MODE_PRIVATE)
        if(!viewModel.hasRun) {
            getData()
            changeFragment(AnantHomeFragment(), "a")
            viewModel.hasRun = true
        }

        btnEnglish = findViewById(R.id.btnEnglish)
        btnHindi = findViewById(R.id.btnHindi)
        btnMarathi = findViewById(R.id.btnMarathi)

        val currentLang = Locale.getDefault().language
        updateLanguageButtons(currentLang)

        btnHindi.setOnClickListener {
            setLocale("hi")
            recreate()
            lastOpenedFragment()
        }

        btnEnglish.setOnClickListener {
            setLocale("en")
            recreate()
            lastOpenedFragment()
        }

        btnMarathi.setOnClickListener {
            setLocale("mr")
            recreate()
            lastOpenedFragment()
        }

        openAndCloseDrawer()

        val menuItemList = mutableListOf<Any> ()
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_1), "f", AnantIntroFragment()))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_2), "g", AnantEarlyLifeFragment()))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_3), "h", AnantRevolutionaryFragment()))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_4), null, null, true, listOf(ChildMenu(getString(R.string.anant_drawer_4_1), AnantAMTJacksonFragment(), "o"), ChildMenu(getString(R.string.anant_drawer_4_2), AnantAssassinationFragment(), "p"), ChildMenu(getString(R.string.anant_drawer_4_5), AnantArrestTrial(), "q"), ChildMenu(getString(R.string.anant_drawer_4_3), AnantMediaAndPublicFragment(), "r"), ChildMenu(getString(R.string.anant_drawer_4_4), AnantImpactRevolutionaryFragment(), "s"))))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_5), "i", AnantSymbolOfYouthFragment()))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_6), "j", AnantIdeologicalBeliefFragment()))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_7), "k", AnantBritishResponseFragment()))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_8), "l", AnantPsycologocalFragment()))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_9), "m", AnantLegacyFragment()))
        menuItemList.add(DrawerMenuItem(getString(R.string.anant_drawer_10), "n", AnantRadicalRevolutionaryVisionFragment()))

        adapter = DrawerMenuAdapter(menuItemList, ::changeFragment)

        binding.drawerRecyclerView.adapter = adapter

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.bottm_nav1 -> changeFragment(AnantHomeFragment(), "a")
                R.id.bottm_nav2 -> changeFragment(AnantBottomSecondFragment(), "b")
                R.id.bottm_nav3 -> changeFragment(AnantBottomThirdFragment(), "c")
                R.id.bottm_nav4 -> changeFragment(AnantBottomFourthFragment(), "d")
                R.id.bottm_nav5 -> changeFragment(AnantBottomFifthFragment(), "e")

                else -> {}
            }

            true

        }

//        NavigationUI.setupWithNavController(binding.bottomNavigationView,
//            Navigation.findNavController(this, R.id.frameLayoutContainer)
//        )
//
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.frameLayoutContainer, AnantHomeFragment())
//                .commit()
//        }

    }

    private fun getData() {
        val bundle = intent.extras
        val s = bundle!!.getString("lCode", "en")
        setLocale(s)
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

    private fun changeFragment(fragment: Fragment, fCode: String?) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayoutContainer, fragment)
            .commit()

        sharedPreferences.edit().putString("last_openFragment", fCode).apply()

        binding.drawer.closeDrawer(GravityCompat.START)
    }

    override fun onBackPressed() {

        currentFragment = supportFragmentManager.findFragmentById(R.id.frameLayoutContainer)!!

        if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
            binding.drawer.closeDrawer(GravityCompat.START)
        } else if (currentFragment != AnantHomeFragment()) {
            changeFragment(AnantHomeFragment(), "a")
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

        binding.drawer.closeDrawer(GravityCompat.START)
    }

    private fun lastOpenedFragment() {

        val lastFragmentCode = sharedPreferences.getString("last_openFragment", "a")
        when (lastFragmentCode) {
            "a" -> changeFragment(AnantHomeFragment(), "a")
            "b" -> changeFragment(AnantBottomSecondFragment(), "b")
            "c" -> changeFragment(AnantBottomThirdFragment(), "c")
            "d" -> changeFragment(AnantBottomFourthFragment(), "d")
            "e" -> changeFragment(AnantBottomFifthFragment(), "e")
            "f" -> changeFragment(AnantIntroFragment(), "f")
            "g" -> changeFragment(AnantEarlyLifeFragment(), "g")
            "h" -> changeFragment(AnantRevolutionaryFragment(), "h")
            "i" -> changeFragment(AnantSymbolOfYouthFragment(), "i")
            "j" -> changeFragment(AnantIdeologicalBeliefFragment(), "j")
            "k" -> changeFragment(AnantBritishResponseFragment(), "k")
            "l" -> changeFragment(AnantPsycologocalFragment(), "l")
            "m" -> changeFragment(AnantLegacyFragment(), "m")
            "n" -> changeFragment(AnantRadicalRevolutionaryVisionFragment(), "n")
            "o" -> changeFragment(AnantAMTJacksonFragment(), "o")
            "p" -> changeFragment(AnantAssassinationFragment(), "p")
            "q" -> changeFragment(AnantArrestTrial(), "q")
            "r" -> changeFragment(AnantMediaAndPublicFragment(), "r")
            "s" -> changeFragment(AnantImpactRevolutionaryFragment(), "s")

            else -> {}
        }

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
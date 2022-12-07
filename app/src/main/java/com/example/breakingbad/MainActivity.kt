package com.example.breakingbad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.breakingbad.fragments.DeathFragment
import com.example.breakingbad.fragments.EpisodeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)


        bottomNav = findViewById(R.id.bottom_navigation) as BottomNavigationView
        bottomNav.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.itemEpisodeMenu -> {
                    loadEpisodeFragment(EpisodeFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.itemDeathMenu -> {
                    leadDeathFragment(DeathFragment())
                    return@setOnNavigationItemReselectedListener
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    //load fun for episode fragment
    private fun loadEpisodeFragment(fragment: EpisodeFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    // load fun for death fragment
    private fun leadDeathFragment(fragment: DeathFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
@file:Suppress("DEPRECATION")

package com.example.medapp.activitie

import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.medapp.R
import com.example.medapp.fragment.Diseases_fragment
import com.example.medapp.fragment.Home_fragment
import com.example.medapp.pat_fragment.Personal_details_fragment
import com.example.medapp.pat_fragment.Profile_fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var coordinatorLayout: CoordinatorLayout
    private lateinit var toolbar: Toolbar
    private lateinit var frameLayout: FrameLayout
    private lateinit var navigationView : NavigationView

    private var previousMenuItems : MenuItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawerLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frameLayout)
        navigationView = findViewById(R.id.navigationView)

        setuptoolbar()

        opendashboard()

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            if (previousMenuItems != null){
                previousMenuItems?.isChecked = false
            }

            it.isCheckable = true
            it.isChecked = true
            previousMenuItems = it

            when (it.itemId) {
                R.id.nav_dashboard -> {
                    opendashboard()
                    drawerLayout.closeDrawers()

                }

                R.id.nav_profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, Profile_fragment())
                        .commit()

                    supportActionBar?.title = "Profile_fragment"
                    drawerLayout.closeDrawers()
                }

                R.id.nav_favourite -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, Personal_details_fragment())
                        .commit()

                    supportActionBar?.title = "Favourite"
                    drawerLayout.closeDrawers()
                }

                R.id.nav_about -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, Diseases_fragment())
                        .commit()

                    supportActionBar?.title = "About"
                    drawerLayout.closeDrawers()
                }
            }
            return@setNavigationItemSelectedListener true
        }
    }


    private fun setuptoolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title="ToolBar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if(id == android.R.id.home){
            drawerLayout.openDrawer((GravityCompat.START))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun opendashboard(){
        val fragment = Home_fragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
        supportActionBar?.title="DashBoard"
        navigationView.setCheckedItem(R.id.nav_dashboard)
    }


    @Deprecated("This method has been deprecated in favor of using the\n      {@link OnBackPressedDispatcher} via {@link #getOnBackPressedDispatcher()}.\n      The OnBackPressedDispatcher controls how back button events are dispatched\n      to one or more {@link OnBackPressedCallback} objects.")
    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frameLayout)

        when (frag) {
            !is Home_fragment -> opendashboard()

            else -> super.onBackPressed()
        }
    }
}

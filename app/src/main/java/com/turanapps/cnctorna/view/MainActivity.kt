package com.turanapps.cnctorna.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.turanapps.cnctorna.R
import com.turanapps.cnctorna.databinding.ActivityMainBinding
import com.turanapps.cnctorna.view.fragments.CommunicationFragment
import com.turanapps.cnctorna.view.fragments.MainFragment
import com.turanapps.cnctorna.view.fragments.OurServicesFragment
import com.turanapps.cnctorna.view.fragments.ProductsFragment
import com.turanapps.cnctorna.view.fragments.institutional.AboutUsFragment
import com.turanapps.cnctorna.view.fragments.institutional.FrequentlyAskedQuestionsFragment
import com.turanapps.cnctorna.view.fragments.institutional.OurMachineParkFragment
import com.turanapps.cnctorna.view.fragments.institutional.SolutionPartnersFragment
import com.turanapps.cnctorna.view.fragments.products.MetalFragment
import com.turanapps.cnctorna.view.fragments.products.PlasticFragment
import com.turanapps.cnctorna.view.fragments.products.metals.AluminumFragment
import com.turanapps.cnctorna.view.fragments.products.metals.BronzeFragment
import com.turanapps.cnctorna.view.fragments.products.metals.CastIronFragment
import com.turanapps.cnctorna.view.fragments.products.metals.CopperFragment
import com.turanapps.cnctorna.view.fragments.products.metals.NickelFragment
import com.turanapps.cnctorna.view.fragments.products.metals.StainlessSteelFragment
import com.turanapps.cnctorna.view.fragments.products.metals.SteelFragment
import com.turanapps.cnctorna.view.fragments.products.metals.TitaniumFragment
import com.turanapps.cnctorna.view.fragments.products.metals.YellowMetalFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var drawerLayout: DrawerLayout

    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.navView.setNavigationItemSelectedListener(this)

        drawerToggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.open_nav, R.string.close_nav)
        binding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainFragment()).commit()
            binding.navView.setCheckedItem(R.id.main)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.main -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainFragment()).commit()

            R.id.institutional -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainFragment()).commit()

            R.id.about_us -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AboutUsFragment()).commit()

            R.id.our_machine_park -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, OurMachineParkFragment()).commit()

            R.id.solution_partners -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SolutionPartnersFragment()).commit()

            R.id.frequently_asked_questions -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FrequentlyAskedQuestionsFragment()).commit()

            R.id.our_services -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, OurServicesFragment()).commit()

            R.id.products -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProductsFragment()).commit()

            /*
            R.id.metal -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MetalFragment()).commit()

            R.id.plastic -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PlasticFragment()).commit()

             */

            R.id.communication -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CommunicationFragment()).commit()
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            onBackPressedDispatcher.onBackPressed()
        }
    }

}
package com.example.arstrack.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.arstrack.R
import com.example.arstrack.activity.dbconnection.ConnectionProvider
import com.example.arstrack.activity.productsection.ProductsActivity
import com.example.arstrack.activity.servicesection.ServicesActivity
import com.google.android.material.navigation.NavigationView
import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var nav: NavigationView? = null
    var drawerLayout: DrawerLayout? = null
    var toggle: ActionBarDrawerToggle? = null
    var toolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* --------------Hooks--------------- */

        toolbar = findViewById(R.id.homeScreenToolbar)
        nav = findViewById(R.id.navView)
        drawerLayout = findViewById(R.id.navDrawer)

        /* --------------Toolbar--------------- */

        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)?.setDisplayShowTitleEnabled(false)

        /* --------------Navigation Drawer--------------- */

        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout?.addDrawerListener(toggle!!)
        toggle!!.syncState()
        nav?.setNavigationItemSelectedListener(this)

        /* --------------Handle onClicks on the card views------------------- */

        findViewById<View>(R.id.servicesCardView).setOnClickListener {
            startActivity(
                Intent(this@MainActivity, ServicesActivity::class.java)
            )
        }

        findViewById<View>(R.id.productsCardView).setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    ProductsActivity::class.java
                )
            )
        }

    }

    /*--------------Handle click items on navigation drawer------------ */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.share) {
            drawerLayout!!.closeDrawer(GravityCompat.START)
        }
        if (item.itemId == R.id.rate) {
            drawerLayout!!.closeDrawer(GravityCompat.START)
        }
        if (item.itemId == R.id.logout) {
            drawerLayout!!.closeDrawer(GravityCompat.START)
        }
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            drawerLayout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
package com.example.arstrack.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.arstrack.R
import java.util.*

class ServicesActivity : AppCompatActivity() {
    var toolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        /* --------------Hooks--------------- */

        toolbar = findViewById(R.id.servicesScreenToolbar)

        /* --------------Toolbar--------------- */

        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)?.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        /* --------------Handle onClicks on the card views------------------- */

        findViewById<View>(R.id.complaintsCardView).setOnClickListener {
            startActivity(
                Intent(this@ServicesActivity, ComplaintActivity::class.java)
            )
        }

        findViewById<View>(R.id.repairingCardView).setOnClickListener {
            startActivity(
                Intent(
                    this@ServicesActivity,
                    RepairingActivity::class.java
                )
            )
        }

        findViewById<View>(R.id.warrantyCardView).setOnClickListener {
            startActivity(
                Intent(
                    this@ServicesActivity,
                    WarrantyActivity::class.java
                )
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
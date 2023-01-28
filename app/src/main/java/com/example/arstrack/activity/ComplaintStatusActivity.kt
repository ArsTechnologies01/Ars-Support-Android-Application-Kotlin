package com.example.arstrack.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.arstrack.R
import java.util.*

class ComplaintStatusActivity : AppCompatActivity() {
    var toolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complaint_status)

        /* --------------Hooks--------------- */

        toolbar = findViewById(R.id.ComplaintStatusScreenToolbar)

        /* --------------Toolbar--------------- */

        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)?.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        /* --------------Handle onClicks on Back Button------------------- */

        findViewById<View>(R.id.BackButton).setOnClickListener {
            startActivity(
                Intent(
                    this@ComplaintStatusActivity,
                    ComplaintActivity::class.java
                )
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
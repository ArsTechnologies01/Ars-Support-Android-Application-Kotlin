package com.example.arstrack.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arstrack.R
import com.example.arstrack.activity.adapters.ComplaintAdapter
import com.example.arstrack.activity.models.ComplaintModel
import java.util.*

class ComplaintActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var toolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complaint)

        /* --------------Hooks--------------- */

        recyclerView = findViewById(R.id.complaintRecyclerView)
        toolbar = findViewById(R.id.complaintScreenToolbar)

        /* --------------Toolbar--------------- */

        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)?.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val list = ArrayList<ComplaintModel>()
        list.add(ComplaintModel("Complaint Id #101", "Response Pending", "Details"))
        list.add(ComplaintModel("Complaint Id #101", "Response Pending", "Details"))
        val adapter = ComplaintAdapter(list, this)
        recyclerView?.setAdapter(adapter)
        val layoutManager = LinearLayoutManager(this)
        recyclerView?.setLayoutManager(layoutManager)

        /* --------------Handle onClicks on Add New Complaint Button------------------- */

        findViewById<View>(R.id.lodgeComplaintButton).setOnClickListener {
            startActivity(Intent(this@ComplaintActivity, NewComplaintActivity::class.java))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

package com.example.arstrack.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arstrack.R
import com.example.arstrack.activity.adapters.ProductAdapter
import com.example.arstrack.activity.models.ProductModel
import java.util.*

class ProductsActivity : AppCompatActivity() {
    var toolbar: Toolbar? = null
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        /* --------------Hooks--------------- */

        toolbar = findViewById(R.id.productsScreenToolbar)
        recyclerView = findViewById(R.id.productScreenRecyclerView)

        /* --------------Toolbar--------------- */

        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)?.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        /* --------------Recycler View-------------*/

        val list = ArrayList<ProductModel>()
        list.add(ProductModel("Printer Name", R.drawable.fop_image1))
        list.add(ProductModel("Printer Name", R.drawable.fop_image1))
        list.add(ProductModel("Printer Name", R.drawable.fop_image1))
        list.add(ProductModel("Printer Name", R.drawable.fop_image1))
        list.add(ProductModel("Printer Name", R.drawable.fop_image1))
        list.add(ProductModel("Printer Name", R.drawable.fop_image1))
        list.add(ProductModel("Printer Name", R.drawable.fop_image1))
        list.add(ProductModel("Printer Name", R.drawable.fop_image1))
        list.add(ProductModel("Printer Name", R.drawable.fop_image1))
        list.add(ProductModel("Printer Name", R.drawable.fop_image1))
        list.add(ProductModel("Printer Name", R.drawable.fop_image1))
        list.add(ProductModel("Printer Name", R.drawable.fop_image1))
        list.add(ProductModel("Printer Name", R.drawable.fop_image1))
        val adapter = ProductAdapter(list, this)
        recyclerView?.setAdapter(adapter)
        val layoutManager = LinearLayoutManager(this)
        recyclerView?.setLayoutManager(layoutManager)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
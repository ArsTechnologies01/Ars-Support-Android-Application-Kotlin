package com.example.arstrack.activity.productsection

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arstrack.R
import com.example.arstrack.activity.adapters.ProductAdapter
import com.example.arstrack.activity.dbconnection.ConnectionProvider
import com.example.arstrack.activity.models.ProductModel
import com.example.arstrack.activity.models.ProductTableData
import com.facebook.shimmer.ShimmerFrameLayout
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.collections.ArrayList

public var productDetail: ArrayList<ProductTableData>? = null

class ProductsActivity : AppCompatActivity() {
    var toolbar: Toolbar? = null
    var recyclerView: RecyclerView? = null
    lateinit var shimmer: ShimmerFrameLayout
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        /* --------------Hooks--------------- */

        toolbar = findViewById(R.id.productsScreenToolbar)
        recyclerView = findViewById(R.id.productScreenRecyclerView)
        shimmer = findViewById(R.id.products_activity_shimmer)

        /* --------------Toolbar--------------- */

        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)?.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        /* --------------Recycler View-------------*/

        var i = false
        val list = ArrayList<ProductModel>()
        val service: ExecutorService = Executors.newSingleThreadExecutor()
        service.execute(Runnable {

            try {
                val con = ConnectionProvider.connection
                val query = "select * from products"
                val statement: Statement? = con?.createStatement()
                val resultSet: ResultSet? = statement?.executeQuery(query)

                if (resultSet != null) {
                    while (resultSet.next()) {
                        val id = resultSet.getInt(1)
                        val name = resultSet.getString(2)
                        val description = resultSet.getString(3)
                        val categroyId = resultSet.getInt(4)
                        val stockCount = resultSet.getInt(5)
                        val createdAt = resultSet.getString(6)
                        val updatedAt = resultSet.getString(7)
                        val image = resultSet.getBlob("image")
                        list.add(ProductModel(name, image,stockCount,description,id))
                        productDetail?.add(
                            ProductTableData(
                                id,
                                name,
                                description,
                                categroyId,
                                stockCount,
                                createdAt,
                                updatedAt,
                                image
                            )
                        )
                    }
                    i = true
                }
            } catch (e: Exception) {
                Log.d("Connection", e.message!!)
            }
            runOnUiThread(Runnable {
                kotlin.run {

                    adapter = ProductAdapter(list, this)
                    recyclerView?.adapter = adapter
                    val layoutManager = LinearLayoutManager(this)
                    recyclerView?.layoutManager = layoutManager
                    if (i) {
                        shimmer.stopShimmer()
                        shimmer.visibility = View.GONE
                    }
                }
            })
        })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

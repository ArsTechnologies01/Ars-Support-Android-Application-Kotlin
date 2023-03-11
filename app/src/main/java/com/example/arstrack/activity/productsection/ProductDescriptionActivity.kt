package com.example.arstrack.activity.productsection

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.arstrack.R
import com.example.arstrack.activity.dbconnection.ConnectionProvider
import java.io.InputStream
import java.sql.Blob
import java.sql.ResultSet
import java.sql.Statement
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ProductDescriptionActivity : AppCompatActivity() {
    var toolbar: Toolbar? = null
    lateinit var productImage: ImageView
    lateinit var productName: TextView
    lateinit var productStock: TextView
    lateinit var productDescription: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_description)

        /* --------------Hooks--------------- */

        toolbar = findViewById(R.id.productDescriptionToolbar)
        productImage = findViewById(R.id.productDescriptionImg)
        productName = findViewById(R.id.productDescriptionName)
        productStock = findViewById(R.id.productDescriptionStock)
        productDescription = findViewById(R.id.productDesc)

        /* --------------Toolbar--------------- */

        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)?.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)



        productName.text = intent.getStringExtra("name")
        val stockText = "Available stock: " + intent.getStringExtra("stock")
        productStock.text = stockText
        productDescription.text = intent.getStringExtra("description")

        val service: ExecutorService = Executors.newSingleThreadExecutor()
        service.execute(Runnable {
            var image: Blob? = null
            try {
                val con = ConnectionProvider.connection
                val id = intent.getStringExtra("id")
                val query = "select image from products where id = $id"
                val statement: Statement? = con?.createStatement()
                val resultSet: ResultSet? = statement?.executeQuery(query)
                if (resultSet != null) {
                    if (resultSet.next()) {
                        image = resultSet.getBlob(1)
                        val stream: InputStream = image.binaryStream
                        productImage.setImageBitmap(BitmapFactory.decodeStream(stream))
                    }
                }
                Log.d("ProductDescription", "image fetched")
            } catch (e: Exception) {
                Log.d("ProductDescription", e.message!!)
                Log.d("ProductDescription", "image not fetched")
            }
            runOnUiThread(Runnable {
                kotlin.run {
                    val stream: InputStream? = image?.binaryStream
                    productImage.setImageBitmap(BitmapFactory.decodeStream(stream))
                    Log.d("ProductDescription", "image showing")
                }
            })
        })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
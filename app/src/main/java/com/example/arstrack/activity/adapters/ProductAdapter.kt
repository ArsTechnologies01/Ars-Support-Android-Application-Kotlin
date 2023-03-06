package com.example.arstrack.activity.adapters

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.arstrack.R
import com.example.arstrack.activity.models.ProductModel
import com.example.arstrack.activity.productsection.ProductDescriptionActivity
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.sql.Blob
import java.util.Base64

public class ProductAdapter(var list: ArrayList<ProductModel>, var context: Context) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.products_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val model = list[position]
        val img: Blob = model.img
        val stream: InputStream = img.binaryStream

        holder.productImage.setImageBitmap(BitmapFactory.decodeStream(stream))
        holder.productName.text = model.name
        holder.productItemLayout.setOnClickListener {
            val intent = Intent(context,ProductDescriptionActivity::class.java)
            intent.putExtra("name",model.name)

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productName: TextView
        var productImage: ImageView
        var productItemLayout: CardView

        init {
            productName = itemView.findViewById(R.id.product_name)
            productImage = itemView.findViewById(R.id.product_image)
            productItemLayout = itemView.findViewById(R.id.products_item_layout)
        }
    }
}
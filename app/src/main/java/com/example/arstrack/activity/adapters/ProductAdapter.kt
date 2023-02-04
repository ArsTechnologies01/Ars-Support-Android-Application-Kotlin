package com.example.arstrack.activity.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.arstrack.R
import com.example.arstrack.activity.models.ProductModel

public class ProductAdapter(var list: ArrayList<ProductModel>, var context: Context) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.products_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val model = list[position]
        holder.productImage.setImageResource(model.img)
        holder.productName.text = model.name
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productName: TextView
        var productImage: ImageView
        var productItemLayout : CardView

        init {
            productName = itemView.findViewById(R.id.product_name)
            productImage = itemView.findViewById(R.id.product_image)
            productItemLayout = itemView.findViewById(R.id.products_item_layout)
        }
    }
}
package com.example.arstrack.activity.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.arstrack.R
import com.example.arstrack.activity.models.ComplaintModel

public class ComplaintAdapter(var list: ArrayList<ComplaintModel>, var context: Context) :
    RecyclerView.Adapter<ComplaintAdapter.ComplaintViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComplaintViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.complaintcustomlayout, parent, false)
        return ComplaintViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComplaintViewHolder, position: Int) {
        val model = list[position]
        holder.complaintId.text = model.complaintIdTV
        holder.complaintStatus.text = model.complaintStatusTV
        holder.complaintDetails.text = model.complaintDetailsTV
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ComplaintViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var complaintId: TextView
        var complaintDetails: TextView
        var complaintStatus: TextView

        init {
            complaintId = itemView.findViewById(R.id.complaintsIdTextview)
            complaintDetails = itemView.findViewById(R.id.complaintDetails)
            complaintStatus = itemView.findViewById(R.id.complaintStatus)
        }
    }
}
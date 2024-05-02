package com.coba.cobaloopj

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter untuk menampilkan data listReview ke dalam RecyclerView
class BodyAdapter(private val listReview: ArrayList<String>) : RecyclerView.Adapter<BodyAdapter.ViewHolder>() {
    // Membuat ViewHolder baru
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Inflate layout untuk tiap item dalam RecyclerView
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_body, viewGroup, false)
        return ViewHolder(view)
    }

    // Mengikat data dari listReview ke ViewHolder
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvItem.text = listReview[position]
    }

    // Mengembalikan jumlah item dalam listReview
    override fun getItemCount(): Int {
        return listReview.size
    }

    // ViewHolder untuk setiap item dalam RecyclerView
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvItem: TextView = view.findViewById(R.id.tvItem)
    }
}
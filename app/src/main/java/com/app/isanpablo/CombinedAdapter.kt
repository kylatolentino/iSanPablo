package com.app.isanpablo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2


class CombinedAdapter(private val items: List<Pair<Int, String>>, private val viewPager2: ViewPager2) : RecyclerView.Adapter<CombinedAdapter.CombinedViewHolder>() {

    interface ViewPager2ClickListener {
        fun onItemClick(item: Pair<Int, String>)
    }

    var viewPager2ClickListener: ViewPager2ClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CombinedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tourism_container, parent, false)
        return CombinedViewHolder(view)
    }

    override fun onBindViewHolder(holder: CombinedViewHolder, position: Int)     {
        val currentItem = items[position]
        holder.bind(currentItem)
        holder.itemView.setOnClickListener {
            // Pass the click event to the ViewPager2 click listener
            viewPager2ClickListener?.onItemClick(currentItem)
        }
    }

    override fun getItemCount() = items.size

    // ViewHolder for the combined view
    class CombinedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleTextView: TextView = itemView.findViewById(R.id.textView)

        fun bind(item: Pair<Int, String>) {
            imageView.setImageResource(item.first)
            titleTextView.text = item.second
        }
    }
}

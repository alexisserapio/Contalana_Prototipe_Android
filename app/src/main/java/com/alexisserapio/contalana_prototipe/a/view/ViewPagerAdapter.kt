package com.alexisserapio.contalana_prototipe.a.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alexisserapio.contalana_prototipe.R
import com.alexisserapio.contalana_prototipe.a.model.informativePage

class ViewPagerAdapter(private val items: List<informativePage>) : RecyclerView.Adapter<ViewPagerAdapter.PageViewHolder>() {
    class PageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val pageImage = itemView.findViewById<ImageView>(R.id.ivMockup)
        val pageTopText = itemView.findViewById<TextView>(R.id.topLabel)
        val pageBotText = itemView.findViewById<TextView>(R.id.bottomLabel)

        fun render(informativePage: informativePage){
            pageImage.setImageResource(R.drawable.mockup)
            pageTopText.text = informativePage.title
            pageBotText.text = informativePage.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_informative, parent, false)
        return PageViewHolder(view)
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        val item = items[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = items.size
}


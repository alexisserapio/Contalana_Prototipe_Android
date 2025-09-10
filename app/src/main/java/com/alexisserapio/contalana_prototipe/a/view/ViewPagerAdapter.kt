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

        val pageImage: ImageView = itemView.findViewById(R.id.ivMockup)
        val pageTopText: TextView = itemView.findViewById(R.id.topLabel)
        val pageBotText: TextView = itemView.findViewById(R.id.bottomLabel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_informative, parent, false)
        return PageViewHolder(view)
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        val item = items[position]
        val context = holder.pageImage.context
        val imageName = item.poster
        val resourceId = context.resources.getIdentifier(imageName, "drawable", context.packageName)

    // Ahora puedes usar el ID de recurso para establecer la imagen
        holder.pageImage.setImageResource(resourceId)
        holder.pageTopText.text = item.title
        holder.pageBotText.text = item.description
    }

    override fun getItemCount(): Int = items.size
}


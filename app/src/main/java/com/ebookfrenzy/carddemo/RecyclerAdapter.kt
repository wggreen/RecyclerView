package com.ebookfrenzy.carddemo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext
import kotlin.random.Random

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val data = Data()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        val randomIndexTitle = Random.nextInt(data.titles.size)
        val randomIndexDetail = Random.nextInt(data.details.size)
        val randomIndexImage = Random.nextInt(data.images.size)

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View ->
                val i = Intent(v.getContext(),SecondActivity::class.java)

                i.putExtra("image", data.images[randomIndexImage])
                i.putExtra("title", itemTitle.text.toString())
                i.putExtra("detail", itemDetail.text.toString())

                val context = v.context

                context.startActivity(i)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        viewHolder.itemTitle.text = data.titles[viewHolder.randomIndexTitle]
        viewHolder.itemDetail.text = data.details[viewHolder.randomIndexDetail]
        viewHolder.itemImage.setImageResource(data.images[viewHolder.randomIndexImage])
    }

    override fun getItemCount(): Int {
        return data.titles.size
    }
}
package com.gdsc.mio.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gdsc.mio.model.PlaceData
import com.gdsc.mio.R

class PlaceAdapter(private val itemList: ArrayList<PlaceData>): RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    private var itemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = itemList[position].name
        holder.road.text = itemList[position].road
        // 아이템 클릭 이벤트
        holder.itemView.setOnClickListener {
            itemClickListener?.onClick(it, position)
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tv_list_name)
        val road: TextView = itemView.findViewById(R.id.tv_list_road)
    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
}
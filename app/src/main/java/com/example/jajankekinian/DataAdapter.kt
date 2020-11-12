package com.example.jajankekinian

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class DataAdapter ( val snackItemList: List<SnackData>,
                    val clickListener: (SnackData) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent,false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(snackItemList[position], clickListener)
    }

    override fun getItemCount() = snackItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(snack: SnackData, clickListener: (SnackData) -> Unit) {
            itemView.tv_part_item_name.text = snack.nama
            itemView.imageList.setImageResource(snack.foto)
            itemView.setOnClickListener{ clickListener(snack)}
        }
    }
}

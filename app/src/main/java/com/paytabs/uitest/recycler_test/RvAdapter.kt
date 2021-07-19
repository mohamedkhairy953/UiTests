package com.paytabs.uitest.recycler_test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paytabs.uitest.R
import com.paytabs.uitest.databinding.RvItemBinding

class RvAdapter(private val list: List<String>,private val onClick: (item: String) -> Unit) :
    RecyclerView.Adapter<VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val bind = RvItemBinding.bind(holder.itemView)
        bind.tvHeader.text = list[position]
        bind.tvSubHeader.text = list[position] + " Sub Headed"
        bind.root.setOnClickListener{
            onClick(list[position])
        }
    }

    override fun getItemCount() = list.size

}

class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

}

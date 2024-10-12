package com.example.quranproject.ui.home.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quranproject.databinding.ItemHadethNameBinding
import com.example.quranproject.ui.model.Hadeth

class HadethNameRecyclerAdapter(private var items: List<Hadeth>?) :
    RecyclerView.Adapter<HadethNameRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val viewBinding: ItemHadethNameBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemHadethNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    fun bindItems(newList: MutableList<Hadeth>) {
        items = newList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.hadethName.text = items!![position].title
        holder.viewBinding.hadethName.setOnClickListener {
            onItemClickListener?.onItemClick(position, items!![position])
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, item: Hadeth)
    }

    var onItemClickListener: OnItemClickListener? = null
}

/*
package com.example.quranproject.ui.home.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quranproject.databinding.ItemHadethNameBinding
import com.example.quranproject.ui.model.Hadeth

class HadethNameRecyclerAdapter(private var items:List<Hadeth>?):RecyclerView.Adapter<HadethNameRecyclerAdapter.ViewHolder>() {
    class ViewHolder(val viewBindind: ItemHadethNameBinding) :
        RecyclerView.ViewHolder(viewBindind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBindind =
            ItemHadethNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBindind)
    }
    fun bindItems(newList:MutableList<Hadeth>)
    {
        items = newList
        notifyDataSetChanged()


    }

    override fun getItemCount(): Int = items?.size ?:0


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBindind.hadethName.text = items!![position].title
        if (onItemClickListener != null) {
            holder.viewBindind.hadethName.setOnClickListener {
                onItemClickListener?.onItemClick(position, items!![position])
            }
        }

    }

    fun  interface OnItemClickListener{
        fun onItemClick(position: Int, item:Hadeth)
    }
    var onItemClickListener:OnItemClickListener? = null

}
*/

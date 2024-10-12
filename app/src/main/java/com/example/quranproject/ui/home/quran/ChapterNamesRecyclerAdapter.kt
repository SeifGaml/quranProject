package com.example.quranproject.ui.home.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quranproject.databinding.ItemCahpterNameBinding

class ChapterNamesRecyclerAdapter(private val names:List<String>):RecyclerView.Adapter<ChapterNamesRecyclerAdapter.ViewHolder>() {
    class ViewHolder(val viewBinding:ItemCahpterNameBinding)
        :RecyclerView.ViewHolder(viewBinding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemCahpterNameBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)
    }



    override fun getItemCount(): Int =names.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.suraName.text = names[position]
        if (onItemClickListener !=null){
            holder.viewBinding.suraName.setOnClickListener{
                onItemClickListener?.onItemClick(position,names[position])
            }
        }
    }
  fun  interface OnItemClickListener{
       fun onItemClick(position: Int, name:String)
   }
    var onItemClickListener:OnItemClickListener? = null



}
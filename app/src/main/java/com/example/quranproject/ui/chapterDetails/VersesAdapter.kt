package com.example.quranproject.ui.chapterDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quranproject.databinding.ItemVerseBinding

class VersesAdapter(val verses:List<String>) :RecyclerView.Adapter<VersesAdapter.ViewHolder>(){
    class ViewHolder(val bindig:ItemVerseBinding)
        :RecyclerView.ViewHolder(bindig.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bindig = ItemVerseBinding.inflate(LayoutInflater.from(parent.context)
            ,parent,false)
        return ViewHolder(bindig)
    }

    override fun getItemCount():Int =verses.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindig.content.text=verses[position]
    }

}
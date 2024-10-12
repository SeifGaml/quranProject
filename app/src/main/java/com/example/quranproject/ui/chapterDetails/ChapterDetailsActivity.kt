package com.example.quranproject.ui.chapterDetails

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quranproject.databinding.ActivityCahpterDetailsBinding
import com.example.quranproject.ui.constants

class ChapterDetailsActivity :AppCompatActivity(){
    lateinit var viewBinding:ActivityCahpterDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityCahpterDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        initParams()
        initViews()
        loadChapterFile()
    }

    private fun initViews() {
        setSupportActionBar(viewBinding.toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        viewBinding.titleTv.text = chapterName
        supportActionBar?.title = " "

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun loadChapterFile() {
        val fileContent =
            assets.open("$chapterIndex.txt").bufferedReader().use {it.readText()}
        val lines =
            fileContent.trim().split("\n")
        bindVerses(lines)

    }
    lateinit var adapter: VersesAdapter

    private fun bindVerses(lines :List<String>) {
        adapter = VersesAdapter(lines)
        viewBinding.content.versesRecyclerView.adapter=adapter
    }

    lateinit var chapterName:String
     var chapterIndex :Int = 0
    private fun initParams() {
        chapterName =intent.getStringExtra(constants.EXTRA_CHAPTER_NAME)?:" "
        chapterIndex =intent.getIntExtra(constants.EXTRA_CHAPTER_INDEX,0)
    }

}
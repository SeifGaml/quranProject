package com.example.quranproject.ui.home.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quranproject.databinding.FragmentHadethBinding
import com.example.quranproject.ui.constants
import com.example.quranproject.ui.model.Hadeth
import java.io.IOException

class HadethFragment : Fragment() {
    private lateinit var viewBinding: FragmentHadethBinding
    private lateinit var adapter: HadethNameRecyclerAdapter
    private val hadethList = mutableListOf<Hadeth>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHadethBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = HadethNameRecyclerAdapter(null)
        adapter.onItemClickListener = object : HadethNameRecyclerAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, item: Hadeth) {
                showHadethDetails(item)
            }
        }
        viewBinding.recyclerViewHadeth.adapter = adapter
    }

    private fun showHadethDetails(hadeth: Hadeth) {
        val intent = Intent(activity, HadethDetailsActivity::class.java)
        intent.putExtra(constants.EXTRA_HADETH, hadeth)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        loadHadethName()
        bindHadethList()
    }

    private fun bindHadethList() {
        adapter.bindItems(hadethList)
    }

    private fun loadHadethName() {
        try {
            val fileContent =
                requireActivity().assets.open("hadeth.txt").bufferedReader().use { it.readText() }
            val singleHadethList = fileContent.trim().split("#")
            hadethList.clear() // Clear the list before adding new items
            singleHadethList.forEach { element ->
                val lines = element.trim().split("\n")
                val title = lines[0]
                val content = lines.joinToString("\n")
                val hadeth = Hadeth(title, content)
                hadethList.add(hadeth)
            }
        } catch (e: IOException) {
            e.printStackTrace()

        }
    }
}



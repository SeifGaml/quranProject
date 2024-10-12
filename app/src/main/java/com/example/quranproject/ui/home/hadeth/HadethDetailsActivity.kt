

package com.example.quranproject.ui.home.hadeth

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quranproject.databinding.ActivityHadethDetailsBinding
import com.example.quranproject.ui.constants
import com.example.quranproject.ui.model.Hadeth

class HadethDetailsActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityHadethDetailsBinding
    private var hadeth: Hadeth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initViews()
        bindHadeth()
        initParams()
    }

    private fun initViews() {
        setSupportActionBar(viewBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun bindHadeth() {
        viewBinding.titleTv.text = hadeth?.title
        viewBinding.content.content.text = hadeth?.content
    }

    private fun initParams() {
        hadeth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(constants.EXTRA_HADETH) as? Hadeth
        } else {
            intent.getSerializableExtra(constants.EXTRA_HADETH) as? Hadeth
        }
    }
}


/*

package com.example.quranproject.ui.home.hadeth

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quranproject.databinding.ActivityHadethDetailsBinding
import com.example.quranproject.ui.constants
import com.example.quranproject.ui.model.Hadeth

class HadethDetailsActivity :AppCompatActivity() {
    lateinit var viewBinding: ActivityHadethDetailsBinding
    private var hadeth:Hadeth?= null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        viewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
        bindHadeth()
        initParams()

    }



    private fun initViews() {
        setSupportActionBar(viewBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true


    }



        private fun bindHadeth() {
            viewBinding.titleTv.text = hadeth?.title
            viewBinding.content.content.text = hadeth?.content

        }


         var hadeth: Hadeth? = null

        fun initParams() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                hadeth = intent.getSerializableExtra(constants.EXTRA_HADETH, Hadeth::class.java)
            } else {
                intent.getSerializableExtra(constants.EXTRA_HADETH) as Hadeth
            }
        }

}

*/

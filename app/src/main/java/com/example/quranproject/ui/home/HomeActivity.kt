package com.example.quranproject.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.quranproject.R
import com.example.quranproject.databinding.ActivityHomeBinding
import com.example.quranproject.ui.home.hadeth.HadethFragment
import com.example.quranproject.ui.home.quran.QuranFragment
import com.example.quranproject.ui.home.radio.RadioFragment
import com.example.quranproject.ui.home.tasbeh.TasbehFragment
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        viewBinding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.content.bottomNav.setOnItemSelectedListener(
            object :NavigationBarView.OnItemSelectedListener{
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    when(item.itemId){
                        R.id.navigation_quran ->{
                          showTabFragment(QuranFragment())

                        }
                        R.id.navigation_hadeth ->{
                            showTabFragment(HadethFragment())

                        }
                        R.id.navigation_sebha ->{
                            showTabFragment(TasbehFragment())

                        }
                        R.id.navigation_radio ->{
                            showTabFragment(RadioFragment())
                        }

                    }
                    return true

                }

            }
        )
        viewBinding.content.bottomNav.selectedItemId =R.id.navigation_quran

    }
    private fun showTabFragment( fragment:Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .commit()
    }




    }
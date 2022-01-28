package com.smartheard.coctail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartheard.coctail.Adapter.RandomCoctailAdapter
import com.smartheard.coctail.Utils.ApiResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainVM: MainVM by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = "list"
        categoryListData(list)

    }

    private fun categoryListData(list: String) {
        lifecycleScope.launchWhenStarted {
            mainVM.categoryList(list).collect {
                when (it) {
                    is ApiResponse.Failure -> {
                        Log.e("MainActivity", "${it.msg}")
                    }
                    ApiResponse.Loading -> {

                    }
                    is ApiResponse.Success -> {
                        Log.e("Response", "${it.data!!.drinks}")

                        val mainAdapter = RandomCoctailAdapter(it.data)
                        rv_main.layoutManager = LinearLayoutManager(this@MainActivity)
                        rv_main.adapter = mainAdapter

                    }
                }
            }
        }
    }
}


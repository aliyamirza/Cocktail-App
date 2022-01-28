package com.smartheard.coctail

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.smartheard.coctail.Adapter.CocktailAdapter
import com.smartheard.coctail.Adapter.OrdinaryDrinksAdapter
import com.smartheard.coctail.Utils.ApiResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_data_description.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class DataDescription : AppCompatActivity() {

    private val mainVM: MainVM by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_description)

        val coctailList="Cocktail"
        val list ="Ordinary_Drink"
        getOrdinaryDrink(list)
        getCocktail(coctailList)
    }

    private fun getCocktail(coctailList: String) {
        val progressBar = ProgressDialog(this)
        lifecycleScope.launchWhenStarted {
            mainVM.cocktail(coctailList).collect {
                when(it){
                    is ApiResponse.Failure->{
                        Log.e("DataDescription","${it.msg}")
                        progressBar.dismiss()
                    }
                    ApiResponse.Loading->{
                        progressBar.show()
                    }
                    is ApiResponse.Success->{
                        progressBar.dismiss()
                        val adapter = CocktailAdapter(it.data!!)
                        rv_data_des.adapter=adapter
                        Log.e("DataCocktail","${it.data!!.drinks}")
                    }
                }
            }
        }

    }

    private fun getOrdinaryDrink(list: String) {

        val progressBar = ProgressDialog(this)

        lifecycleScope.launchWhenStarted {

            mainVM.ordinaryDrink(list).collect {
                when(it){
                    is ApiResponse.Failure -> {
                        Log.e("DataDescription","${it.msg}")
                        progressBar.dismiss()
                    }
                    ApiResponse.Loading -> {
                     progressBar.show()
                    }
                    is ApiResponse.Success -> {
                        progressBar.dismiss()
                        val adapter= OrdinaryDrinksAdapter(it.data!!)
                        rv_data_des.adapter = adapter
                        rv_data_des.layoutManager = GridLayoutManager(this@DataDescription,2)
                        Log.e("DataDescription","${it.data!!.drinks}")
                    }
                }
            }
        }

    }
}
package com.smartheard.coctail.retrofit

import com.smartheard.coctail.Utils.result
import javax.inject.Inject

class MainRepo @Inject constructor(private val apiService: ApiService) {
    fun categoryList( list:String) =
        result {
            apiService.categoryList(list)
        }

    fun ordinaryDrink(Ordinary_Drink:String) =
        result{
            apiService.ordinaryDrink(Ordinary_Drink)
        }
    fun cocktail(Cocktail:String)=
        result {
            apiService.cocktail(Cocktail)
        }

}
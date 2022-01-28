package com.smartheard.coctail

import androidx.lifecycle.ViewModel
import com.smartheard.coctail.retrofit.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(val mainRepo: MainRepo):ViewModel(){

    fun categoryList(list:String)=
        mainRepo.categoryList(list)

    fun ordinaryDrink(Ordinary_Drink: String)=
        mainRepo.ordinaryDrink(Ordinary_Drink)

    fun cocktail(Cocktail:String)=
        mainRepo.cocktail(Cocktail)
}
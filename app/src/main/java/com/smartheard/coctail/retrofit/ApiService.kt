package com.smartheard.coctail.retrofit

import com.smartheard.coctail.Model.CocktailResponse
import com.smartheard.coctail.Model.OrdinaryResponse
import com.smartheard.coctail.Model.RandomCoctailResponse
import com.smartheard.coctail.Model.NameSearchResponse
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    companion object{
        const val BASE_URL ="https://www.thecocktaildb.com/api/json/v1/1/"
    }


    @POST("search.php")
    suspend fun searchByName(@Query("s" ) search:String):Response<NameSearchResponse>

    @POST("search.php")
    suspend fun searchByFirstLetter(@Query("f" ) search:String):Response<NameSearchResponse>

    @POST("search.php")
    suspend fun searchIngredientByName(@Query("i" ) search:String):Response<NameSearchResponse>

    @POST("lookup.php")
    suspend fun cocktailDetailsById(@Query("i" ) search:String):Response<NameSearchResponse>

    @POST("lookup.php")
    suspend fun IngredientByID(@Query("iid" ) search:String):Response<NameSearchResponse>

    @POST("random.php")
    suspend fun randomCocktail():Response<NameSearchResponse>

    @POST("list.php")
    suspend fun categoryList(@Query("c")list:String):Response<RandomCoctailResponse>

    @POST("filter.php")
    suspend fun ordinaryDrink(@Query("c")Ordinary_Drink:String):Response<OrdinaryResponse>

    @POST("filter.php")
    suspend fun cocktail(@Query("c")Cocktail:String):Response<CocktailResponse>
}
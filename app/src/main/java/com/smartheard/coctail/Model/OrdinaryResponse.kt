package com.smartheard.coctail.Model


import com.google.gson.annotations.SerializedName

data class OrdinaryResponse(
    @SerializedName("drinks")
    val drinks: List<Drink>
) {
    data class Drink(
        @SerializedName("idDrink")
        val idDrink: String,
        @SerializedName("strDrink")
        val strDrink: String,
        @SerializedName("strDrinkThumb")
        val strDrinkThumb: String
    )
}
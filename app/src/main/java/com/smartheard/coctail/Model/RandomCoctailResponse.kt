package com.smartheard.coctail.Model


import com.google.gson.annotations.SerializedName

data class RandomCoctailResponse(
    @SerializedName("drinks")
    val drinks: List<Drink>
) {
    data class Drink(
        @SerializedName("strCategory")
        val strCategory: String
    )
}
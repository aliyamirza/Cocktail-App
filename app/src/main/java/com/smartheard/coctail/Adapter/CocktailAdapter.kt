package com.smartheard.coctail.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smartheard.coctail.Model.CocktailResponse
import com.smartheard.coctail.Model.OrdinaryResponse
import com.smartheard.coctail.R
import kotlinx.android.synthetic.main.layout.view.*

class CocktailAdapter (val cocktailResponse: CocktailResponse): RecyclerView.Adapter<CocktailAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            val list = cocktailResponse.drinks[position]
            txt_name.text = list.idDrink
            txt_title.text = list.strDrink

            setOnClickListener {

            }
            // Toast.makeText(context, "${list.strDrink}", Toast.LENGTH_SHORT).show()

            Glide.with(context).load(list.strDrinkThumb).placeholder(R.drawable.ic_launcher_background).into(image)

        }
    }

    override fun getItemCount(): Int {
        return cocktailResponse.drinks.size
    }

}
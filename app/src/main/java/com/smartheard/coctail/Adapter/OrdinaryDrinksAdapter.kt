package com.smartheard.coctail.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smartheard.coctail.DataDescription
import com.smartheard.coctail.Model.OrdinaryResponse
import com.smartheard.coctail.Model.RandomCoctailResponse
import com.smartheard.coctail.R
import kotlinx.android.synthetic.main.filter_layout.view.*
import kotlinx.android.synthetic.main.layout.view.*

class OrdinaryDrinksAdapter (val ordinaryResponse: OrdinaryResponse ): RecyclerView.Adapter<OrdinaryDrinksAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            val list = ordinaryResponse.drinks[position]
            txt_name.text = list.idDrink
            txt_title.text = list.strDrink

            setOnClickListener {

            }
           // Toast.makeText(context, "${list.strDrink}", Toast.LENGTH_SHORT).show()

            Glide.with(context).load(list.strDrinkThumb).placeholder(R.drawable.ic_launcher_background).into(image)

        }
    }

    override fun getItemCount(): Int {
        return ordinaryResponse.drinks.size
    }

}
package com.smartheard.coctail.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.smartheard.coctail.DataDescription
import com.smartheard.coctail.Model.RandomCoctailResponse
import com.smartheard.coctail.R
import kotlinx.android.synthetic.main.filter_layout.view.*

class RandomCoctailAdapter (val randomCoctailResponse: RandomCoctailResponse):RecyclerView.Adapter<RandomCoctailAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.filter_layout,parent,false)
        return ViewHolder(view).listen { position, type ->
            Toast.makeText(parent.context, "$position", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
        val list = randomCoctailResponse.drinks[position]
            drinkName.text = list.strCategory

            setOnClickListener {
                when(list.strCategory){
                    "Ordinary Drink"->{
                        val intent = Intent(context, DataDescription::class.java)
                        //  intent.putExtra("${list.}")
                        context.startActivity(intent)
                    }
                    "Cocktail"->{
                        val intent2 = Intent(context, DataDescription::class.java)
                        //  intent.putExtra("${list.}")
                        context.startActivity(intent2)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return randomCoctailResponse.drinks.size
    }

}
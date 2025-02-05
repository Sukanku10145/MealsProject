package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MealsAdapter(
    private val mealsLista:List<Meal>,
    private val onClickListener: (Meal) -> Unit) : RecyclerView.Adapter<MealsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MealsViewHolder(layoutInflater.inflate(R.layout.item_meals, parent, false))
    }

    override fun getItemCount(): Int = mealsLista.size

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {
        val item = mealsLista[position]
        holder.render(item, onClickListener)
    }
}
package com.example.myapplication

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.Meal
import com.example.myapplication.databinding.ItemMealsBinding

class MealsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemMealsBinding.bind(view)

    fun render(mealModel: Meal, onClickListener: (Meal) -> Unit) {
        binding.tvMealName.text = mealModel.strMeal
        binding.tvArea.text = mealModel.strArea
        binding.tvTags.text = mealModel.strTags
        binding.tvSource.text = mealModel.strSource
        binding.tvYoutube.text = mealModel.strYoutube
        binding.tvCategory.text = mealModel.strCategory
        binding.tvIngredients.text = mealModel.ingredients.toString()
        Glide.with(binding.ivMealThumb.context).load(mealModel.strMealThumb).into(binding.ivMealThumb)
        itemView.setOnClickListener {
            onClickListener(mealModel)
        }
    }
}
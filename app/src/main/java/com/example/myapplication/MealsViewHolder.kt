package com.example.myapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemMealsBinding

class MealsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemMealsBinding.bind(view)

    fun render(mealModel: Meal, onClickListener: (Meal) -> Unit) {
        binding.tvMealName.text = mealModel.strMeal
        binding.tvArea.text = mealModel.strArea
        binding.tvYoutube.text = mealModel.strYoutube
        binding.tvCategory.text = mealModel.strCategory
        binding.tvIngredients.text = mealModel.ingredients.toString()
        binding.tvTags.text = mealModel.strTags ?: "None"
        binding.tvSource.text = mealModel.strSource ?: "None"
        Glide.with(binding.ivMealThumb.context).load(mealModel.strMealThumb).into(binding.ivMealThumb)
        binding.ibItem.setImageResource(if (mealModel.fav) R.drawable.heart_icon else R.drawable.empty_heart_icon)

        binding.ibItem.setOnClickListener {
            mealModel.fav = !mealModel.fav
            binding.ibItem.setImageResource(if (mealModel.fav) R.drawable.heart_icon else R.drawable.empty_heart_icon)
        }

        itemView.setOnClickListener {
            onClickListener(mealModel)
        }

        binding.tvYoutube.setOnClickListener{

        }
    }
}

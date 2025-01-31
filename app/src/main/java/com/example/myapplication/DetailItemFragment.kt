package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentDetailItemBinding

class DetailItemFragment : Fragment() {

    private var _binding: FragmentDetailItemBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val meal = arguments?.getParcelable<Meal>("meal")

        meal?.let {
            binding.tvMealName.text = it.strMeal
            binding.tvCategory.text = it.strCategory
            binding.tvArea.text = it.strArea
            binding.tvInstructions.text = it.strInstructions
            binding.tvIngredients.text = it.ingredients.toString()
            binding.tvMeasures.text = it.measures.toString()
            binding.tvTags.text = it.strTags
            binding.tvSource.text = it.strSource
            binding.tvYoutube.text = it.strYoutube
            Glide.with(this).load(it.strMealThumb).into(binding.ivMealThumb)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_detail_item, container, false)
        _binding = FragmentDetailItemBinding.inflate(inflater, container, false)
        return binding.root
    }
}
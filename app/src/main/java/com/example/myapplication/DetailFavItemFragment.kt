package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentDetailFavItemBinding

class DetailFavItemFragment : Fragment() {

    private var _binding: FragmentDetailFavItemBinding? = null
    private val binding get() = _binding!!
    private var meal: Meal? = null
    private var star: Int = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        meal = arguments?.getParcelable<Meal>("meal")

        meal?.let {
            binding.tvMealName.text = it.strMeal
            binding.tvCategory.text = it.strCategory
            binding.tvArea.text = it.strArea
            binding.tvInstructions.text = it.strInstructions
            binding.tvIngredients.text = it.ingredients.toString()
            binding.tvMeasures.text = it.measures.toString()
            binding.tvTags.text = it.strTags ?: "None"
            binding.tvSource.text = it.strSource ?: "None"
            binding.tvYoutube.text = it.strYoutube
            binding.etComment.setText(it.comment.toString())
            Glide.with(this).load(it.strMealThumb).into(binding.ivMealThumb)
            star = it.star
            binding.ib1.setImageResource(R.drawable.star_icon)
            binding.ib2.setImageResource(if (it.star > 1) R.drawable.star_icon else R.drawable.empty_star_icon)
            binding.ib3.setImageResource(if (it.star > 2) R.drawable.star_icon else R.drawable.empty_star_icon)
            binding.ib4.setImageResource(if (it.star > 3) R.drawable.star_icon else R.drawable.empty_star_icon)
            binding.ib5.setImageResource(if (it.star > 4) R.drawable.star_icon else R.drawable.empty_star_icon)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailFavItemBinding.inflate(inflater, container, false)

        binding.ib1.setOnClickListener{
            binding.ib2.setImageResource(R.drawable.empty_star_icon)
            binding.ib3.setImageResource(R.drawable.empty_star_icon)
            binding.ib4.setImageResource(R.drawable.empty_star_icon)
            binding.ib5.setImageResource(R.drawable.empty_star_icon)
            star = 1
        }

        binding.ib2.setOnClickListener{
            binding.ib2.setImageResource(R.drawable.star_icon)
            binding.ib3.setImageResource(R.drawable.empty_star_icon)
            binding.ib4.setImageResource(R.drawable.empty_star_icon)
            binding.ib5.setImageResource(R.drawable.empty_star_icon)
            star = 2
        }

        binding.ib3.setOnClickListener{
            binding.ib2.setImageResource(R.drawable.star_icon)
            binding.ib3.setImageResource(R.drawable.star_icon)
            binding.ib4.setImageResource(R.drawable.empty_star_icon)
            binding.ib5.setImageResource(R.drawable.empty_star_icon)
            star = 3
        }

        binding.ib4.setOnClickListener{
            binding.ib2.setImageResource(R.drawable.star_icon)
            binding.ib3.setImageResource(R.drawable.star_icon)
            binding.ib4.setImageResource(R.drawable.star_icon)
            binding.ib5.setImageResource(R.drawable.empty_star_icon)
            star = 4
        }

        binding.ib5.setOnClickListener{
            binding.ib2.setImageResource(R.drawable.star_icon)
            binding.ib3.setImageResource(R.drawable.star_icon)
            binding.ib4.setImageResource(R.drawable.star_icon)
            binding.ib5.setImageResource(R.drawable.star_icon)
            star = 5
        }

        return binding.root
    }

    override fun onStop() {
        super.onStop()
        updateComment()
        updateStar()
    }

    private fun updateComment() {
        meal?.comment = binding.etComment.text.toString()
    }

    private fun updateStar() {
        meal?.star = star
    }
}
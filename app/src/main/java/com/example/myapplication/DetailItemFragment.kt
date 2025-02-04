package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentDetailItemBinding

class DetailItemFragment : Fragment() {

    private var _binding: FragmentDetailItemBinding? = null
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
            binding.tvTags.text = it.strTags
            binding.tvSource.text = it.strSource
            if (binding.tvSource.text == ""){
                binding.tvSource.text = "No hay"
            }
            binding.tvYoutube.text = it.strYoutube
            binding.etComment.setText(it.comment.toString())
            Glide.with(this).load(it.strMealThumb).into(binding.ivMealThumb)
            binding.ib1.setImageResource(R.drawable.star_icon)
            binding.ib2.setImageResource(R.drawable.star_icon)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_detail_item, container, false)
        _binding = FragmentDetailItemBinding.inflate(inflater, container, false)

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

        binding.btnVolver.setOnClickListener{
            updateComment()
            updateStar()
            val request = DetailItemFragmentDirections.actionDetailItemFragmentToItemListFragment()
            findNavController().navigate(request)
        }

        return binding.root
    }

    override fun onPause() {
        super.onPause()
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
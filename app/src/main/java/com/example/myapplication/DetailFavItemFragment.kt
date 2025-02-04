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
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailFavItemBinding.inflate(inflater, container, false)

        binding.btnVolver.setOnClickListener{
            updateComment()
            val request = DetailFavItemFragmentDirections.actionDetailFavItemFragmentToFavItemListFragment()
            findNavController().navigate(request)
        }

        return binding.root
    }

    override fun onPause() {
        super.onPause()
        updateComment() // Guardar comentario cuando el fragmento se cierra
    }

    private fun updateComment() {
        meal?.comment = binding.etComment.text.toString()
    }
}
package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentFavItemListBinding
import com.example.myapplication.databinding.FragmentItemListBinding

class FavItemListFragment : Fragment() {

    private var _binding: FragmentFavItemListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavItemListBinding.inflate(inflater, container, false)
        initRecyclerView()

        binding.btnVolver.setOnClickListener{
            val request = FavItemListFragmentDirections.actionFavItemListFragmentToItemListFragment()
            findNavController().navigate(request)
        }

        return binding.root
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(requireContext())
        binding.rvItemList.layoutManager = manager

        val favoriteMeals = MealData.meals.filter { it.fav }

        binding.rvItemList.adapter = MealsAdapter(favoriteMeals) { meal ->
            onItemSelected(meal)
        }
    }

    private fun onItemSelected(meal: Meal) {
        val request = FavItemListFragmentDirections.actionFavItemListFragmentToDetailFavItemFragment(meal = meal)
        findNavController().navigate(request)
    }
}
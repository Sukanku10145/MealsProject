package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentItemListBinding
import com.example.myapplication.databinding.FragmentUserInfoBinding

class ItemListFragment : Fragment() {

    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_user_info, container, false)
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        //val manager = GridLayoutManager(this,2)
        val manager = LinearLayoutManager(requireContext())
        binding.rvItemList.layoutManager = manager
        binding.rvItemList.adapter = MealsAdapter(MealData.meals) { meal -> onItemSelected(meal) }
    }

    private fun onItemSelected(meal: Meal) {
        Toast.makeText(
            requireContext(),
            meal.strMeal,
            Toast.LENGTH_SHORT
        ).show()
    }
}
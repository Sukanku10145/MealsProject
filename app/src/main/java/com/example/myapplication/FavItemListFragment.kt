package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentFavItemListBinding

class FavItemListFragment : Fragment() {

    private var _binding: FragmentFavItemListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavItemListBinding.inflate(inflater, container, false)
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        filtro()
    }

    override fun onResume() {
        super.onResume()
        filtro()
    }

    private fun onItemSelected(meal: Meal) {
        val request = ViewPagerAppFragmentDirections.actionViewPagerAppFragmentToDetailFavItemFragment(meal = meal)
        findNavController().navigate(request)
    }

    private fun filtro(){
        val manager = LinearLayoutManager(requireContext())
        binding.rvItemList.layoutManager = manager

        val favoriteMeals = MealData.meals.filter { it.fav }

        if (favoriteMeals.isEmpty()) {
            toast() // Llamar a la función toast si no hay elementos en la lista
        }

        binding.rvItemList.adapter = MealsAdapter(favoriteMeals) { meal ->
            onItemSelected(meal)
        }
    }

    private fun toast(){
        Toast.makeText(
            this.context,
            getString(R.string.favToast),
            Toast.LENGTH_SHORT
        ).show()
    }

    companion object {
        const val ARG_DATA = "arg_data"

        fun newInstance(data: String): FavItemListFragment {
            return FavItemListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_DATA, data)
                }
            }
        }
    }
}
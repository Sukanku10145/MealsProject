package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentItemListBinding

class ItemListFragment : Fragment() {

    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!
    private var receivedData: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            receivedData = it.getString(ARG_DATA)
        }
    }

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

    override fun onResume() {
        super.onResume()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        //val manager = GridLayoutManager(this,2)
        val manager = LinearLayoutManager(requireContext())
        binding.rvItemList.layoutManager = manager
        binding.rvItemList.adapter = MealsAdapter(MealData.meals) {
            meal -> onItemSelected(meal)
        }
    }

    private fun onItemSelected(meal: Meal) {
        val request = ViewPagerAppFragmentDirections.actionViewPagerAppFragmentToDetailItemFragment(meal = meal)
        findNavController().navigate(request)
    }

    companion object {
        const val ARG_DATA = "arg_data"

        fun newInstance(data: String): ItemListFragment {
            return ItemListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_DATA, data)
                }
            }
        }
    }
}
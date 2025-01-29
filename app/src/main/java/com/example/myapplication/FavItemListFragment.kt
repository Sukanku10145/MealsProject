package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentFavItemListBinding
import com.example.myapplication.databinding.FragmentItemListBinding
import com.example.myapplication.databinding.FragmentUserInfoBinding

class FavItemListFragment : Fragment() {

    private var _binding: FragmentFavItemListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fav_item_list, container, false)
        _binding = FragmentFavItemListBinding.inflate(inflater, container, false)
        return binding.root
    }
}
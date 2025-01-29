package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentDetailFavItemBinding
import com.example.myapplication.databinding.FragmentFavItemListBinding

class DetailFavItemFragment : Fragment() {

    private var _binding: FragmentDetailFavItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_detail_fav_item, container, false)
        _binding = FragmentDetailFavItemBinding.inflate(inflater, container, false)
        return binding.root
    }
}
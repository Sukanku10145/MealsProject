package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentCreditBinding
import com.example.myapplication.databinding.FragmentMainBinding

class CreditFragment : Fragment() {

    private var _binding: FragmentCreditBinding? = null
    private val binding get() = _binding!!
    private val args: CreditFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_credit, container, false)
        _binding = FragmentCreditBinding.inflate(inflater, container, false)

        binding.tvCre1.text = getString(R.string.tvCre1,args.user)

        return binding.root
    }
}
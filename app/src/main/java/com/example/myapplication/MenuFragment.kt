package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    private val args: MenuFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_menu, container, false)
        _binding = FragmentMenuBinding.inflate(inflater, container, false)

        binding.tvMen1.text = getString(R.string.tvMen1,args.user)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btMen1.setOnClickListener{
            val request = MenuFragmentDirections.actionMenuFragmentToCreditFragment(user = args.user)
            findNavController().navigate(request)
        }
        binding.btMen3.setOnClickListener{
            val request = MenuFragmentDirections.actionMenuFragmentToMainFragment()
            findNavController().navigate(request)
        }
    }
}
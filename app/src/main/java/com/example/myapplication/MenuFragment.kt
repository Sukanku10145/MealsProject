package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
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
        //return inflater.inflate(R.layout.fragment_menu, container, false)
        _binding = FragmentMenuBinding.inflate(inflater, container, false)

        binding.tvMen1.text = getString(R.string.tvMen1,receivedData.toString())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSalir.setOnClickListener{
            val request = ViewPagerFragmentDirections.actionViewPagerFragmentToMainFragment()
            findNavController().navigate(request)
        }

        binding.btMen3.setOnClickListener{
            val request = ViewPagerFragmentDirections.actionViewPagerFragmentToItemListFragment(user = receivedData.toString())
            findNavController().navigate(request)
        }
    }
    companion object {
        private const val ARG_DATA = "arg_data"

        fun newInstance(data: String): MenuFragment {
            return MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_DATA, data)
                }
            }
        }
    }
}
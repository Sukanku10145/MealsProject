package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentUserInfoBinding

class UserInfoFragment : Fragment() {

    private var _binding: FragmentUserInfoBinding? = null
    private val binding get() = _binding!!
    private var receivedData: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            receivedData = it.getString(ItemListFragment.ARG_DATA)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_user_info, container, false)
        _binding = FragmentUserInfoBinding.inflate(inflater, container, false)

        binding.tvUserName.text = receivedData.toString()

        return binding.root
    }

    companion object {
        private const val ARG_DATA = "arg_data"

        fun newInstance(data: String): UserInfoFragment {
            return UserInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_DATA, data)
                }
            }
        }
    }
}
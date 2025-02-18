package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentMainBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main, container, false)

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnMain.setOnClickListener{
            val nombre = binding.etMain.text
            if (nombre.toString() == "") {
                val request =
                    LoginFragmentDirections.actionMainFragmentToViewPagerFragment(user = getString(R.string.usuario))
                findNavController().navigate(request)
            }else {
                val request =
                    LoginFragmentDirections.actionMainFragmentToViewPagerFragment(user = nombre.toString())
                findNavController().navigate(request)
            }
        }

        binding.etMain.setOnClickListener{
            toast()
        }
    }

    private fun toast(){
        Toast.makeText(
            this.context,
            getString(R.string.etMainToast),
            Toast.LENGTH_SHORT
        ).show()
    }
}
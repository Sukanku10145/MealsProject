package com.example.myapplication

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentCreditBinding
import com.example.myapplication.databinding.FragmentMainBinding

class CreditFragment : Fragment() {

    private var _binding: FragmentCreditBinding? = null
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
        //return inflater.inflate(R.layout.fragment_credit, container, false)
        _binding = FragmentCreditBinding.inflate(inflater, container, false)

        binding.tvCre1.text = getString(R.string.tvCre1,receivedData)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCre.setOnClickListener{
            val email = Intent().apply {
                val nombreApp = getString(R.string.app_name)
                action = Intent.ACTION_SEND
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("jrodper914@gmailcom"))
                putExtra(Intent.EXTRA_TEXT, "Consulta de la app $nombreApp")
                type = "text/plain"
            }
            try {
                startActivity(email)
            }catch (e: ActivityNotFoundException){
                println("ERROR")
            }
        }
    }

    companion object {
        private const val ARG_DATA = "arg_data"

        fun newInstance(data: String): CreditFragment {
            return CreditFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_DATA, data)
                }
            }
        }
    }
}
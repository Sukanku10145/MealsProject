package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
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

        val spinner = binding.spinnerTheme
        val sharedPrefs = requireActivity().getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        val savedMode = sharedPrefs.getInt("themeMode", AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        val adapter = ArrayAdapter.createFromResource(requireContext(), R.array.theme_options, android.R.layout.simple_spinner_dropdown_item)
        if (spinner != null) {
            spinner.adapter = adapter
        }

        if (spinner != null) {
            spinner.setSelection(when (savedMode) {
                AppCompatDelegate.MODE_NIGHT_NO -> 1
                AppCompatDelegate.MODE_NIGHT_YES -> 2
                else -> 0
            })
        }

        if (spinner != null) {
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    val newMode = when (position) {
                        1 -> AppCompatDelegate.MODE_NIGHT_NO
                        2 -> AppCompatDelegate.MODE_NIGHT_YES
                        else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                    }

                    sharedPrefs.edit().putInt("themeMode", newMode).apply()
                    AppCompatDelegate.setDefaultNightMode(newMode)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {}
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

private fun toast(){
    Toast.makeText(
        this.context,
        getString(R.string.etMainToast),
        Toast.LENGTH_SHORT
    ).show()
}
}
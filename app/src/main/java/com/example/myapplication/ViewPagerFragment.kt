package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerFragment : Fragment() {

    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!
    private val args: ViewPagerFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val receivedData = args.user
        binding.vpView.adapter = NoticeAdapter(this, receivedData)
        TabLayoutMediator(binding.tabView,binding.vpView){
                tab, position ->
            when(position){
                0 -> {
                    tab.text = getString(R.string.info)
                    tab.setIcon(R.drawable.info_icon)
                }
                1 -> {
                    tab.text = getString(R.string.btStart)
                    tab.setIcon(R.drawable.flag_icon)
                }
            }
        }.attach()
    }
}
class NoticeAdapter(fragment: Fragment, private val data: String) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0)
            CreditFragment.newInstance(data)
        else
            MenuFragment.newInstance(data)
    }
}

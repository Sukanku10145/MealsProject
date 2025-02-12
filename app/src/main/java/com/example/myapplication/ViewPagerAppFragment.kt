package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.databinding.FragmentViewPagerAppBinding
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerAppFragment : Fragment() {

    private var _binding: FragmentViewPagerAppBinding? = null
    private val binding get() = _binding!!
    private val args: ViewPagerAppFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViewPagerAppBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val receivedData = args.user
        binding.vpApp.adapter = NoticeAdapterApp(this, receivedData)
        TabLayoutMediator(binding.tabApp,binding.vpApp){
                tab, position ->
            when(position){
                0 -> {
                    tab.text = getString(R.string.discover)
                    tab.setIcon(R.drawable.discover_icon)
                }
                1 -> {
                    tab.text = getString(R.string.favorite)
                    tab.setIcon(R.drawable.heart_icon)
                }
                2 -> {
                    tab.text = getString(R.string.personal)
                    tab.setIcon(R.drawable.person_icon)
                }
            }
        }.attach()
    }
}
class NoticeAdapterApp(fragment: Fragment, private val data: String) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return if (position == 0)
            ItemListFragment.newInstance(data)
        else if (position == 1)
            FavItemListFragment.newInstance(data)
        else
            UserInfoFragment.newInstance(data)
    }
}

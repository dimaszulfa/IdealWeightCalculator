package com.example.idealweightcalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.idealweightcalculator.databinding.FragmentHomeBinding
import com.example.idealweightcalculator.presentation.MainViewModel
import com.example.idealweightcalculator.view.BottomSheetDialog
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val vm: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        val viewPager: ViewPager2 = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLE[position])
        }.attach()

        binding.fabAdd.setOnClickListener {
            val bottomSheet = BottomSheetDialog()
            bottomSheet.showNow(childFragmentManager, "Fragment")
        }


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun toResultFragment(bundle: Bundle) {
        findNavController().navigate(
            R.id.action_homeFragment2_to_navigation6, bundle
        )
    }

    companion object {
        @StringRes
        private val TAB_TITLE = intArrayOf(
            R.string.tab_alldata,
            R.string.tab_favdata
        )
    }
// (Bundle) -> Unit
}
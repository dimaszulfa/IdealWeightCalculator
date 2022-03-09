package com.example.idealweightcalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.idealweightcalculator.data.BodyMassItem
import com.example.idealweightcalculator.databinding.FragmentHomeBinding
import com.example.idealweightcalculator.databinding.FragmentNestedBinding
import com.example.idealweightcalculator.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class NestedFragment : Fragment() {

    private var _binding : FragmentNestedBinding? = null
    private val binding get() = _binding!!
    private val vm: MainViewModel by viewModel()
    private lateinit var adapter: NestedAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNestedBinding.inflate(inflater, container, false)
        val view = binding.root


        return view






    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = NestedAdapter()
        binding.rvBmi.adapter = adapter
        binding.rvBmi.setHasFixedSize(true)

        vm.getAllBmi()
        vm.bmi.observe(viewLifecycleOwner, Observer{
            adapter.addData(it)

        })

        binding.rvBmi.layoutManager = LinearLayoutManager(activity,
            LinearLayoutManager.VERTICAL,false)



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
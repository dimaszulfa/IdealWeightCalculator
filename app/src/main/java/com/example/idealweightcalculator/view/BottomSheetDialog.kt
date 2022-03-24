package com.example.idealweightcalculator.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.idealweightcalculator.R
import com.example.idealweightcalculator.databinding.FragmentBottomSheetDialogBinding
import com.example.idealweightcalculator.domain.BodyMass
import com.example.idealweightcalculator.presentation.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class BottomSheetDialog() : BottomSheetDialogFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBottomSheetDialogBinding.inflate(layoutInflater, container, false)

        vm.imt.observe(viewLifecycleOwner) {

            if(it != null){
                val bundle = Bundle().apply {
                    putString("bmi", it.BMI.toString())
                    putString("status", it.status)
                }
                vm.addBmi(BodyMass(it.name, it.BMI, it.status))

//                val toResult = BottomSheetDialogDirections.actionBottomSheetDialogToNavigation6()
//                findNavController().navigate(R.id.action_bottomSheetDialog_to_navigation6, bundle)

                 vm.clearImt()

            }

        }

        binding.customButton.onClick {
            binding.customButton.loading = true
            var name = binding.edtName.text.toString()
            var height = binding.edtHeight.text.toString()
            var weight = binding.edtWeight.text.toString()




            when {
                name.isEmpty() -> binding.edtName.error = "Please inout your name"
                height.isEmpty() -> binding.edtHeight.error = "Please input your height"
                weight.isEmpty() -> binding.edtWeight.error = "Please input your weight"
                else -> {
                    vm.calculate(name,height,weight)
/*
                    val bundle = Bundle().apply {
                        putString("bmi", "50.0")
                        putString("status", "OVERWEIGHT")
                    }
                    nav?.navigate(
                        R.id.action_homeFragment2_to_navigation6,bundle
                    )*/
                }
            }
        }
        return binding.root
    }



    private val vm: MainViewModel by viewModel()
    private lateinit var binding: FragmentBottomSheetDialogBinding
    private val nav: NavController? by lazy { activity?.findNavController(R.id.nav_host_fragment) }

}
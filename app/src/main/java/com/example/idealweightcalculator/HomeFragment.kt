package com.example.idealweightcalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.Navigation.findNavController
import com.example.idealweightcalculator.databinding.FragmentHomeBinding
import com.example.idealweightcalculator.presentation.MainViewModel
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

        binding.btnCalculate.setOnClickListener {
            var height = binding.edtHeight.text.toString()
            var weight = binding.edtWeight.text.toString()

            when {
                height.isEmpty() -> binding.edtHeight.error = "Please input your height"
                weight.isEmpty() -> binding.edtWeight.error = "Please input your weight"
                else -> {
//                    viewModel.calculate(height,weight)
                    val result = vm.calculate(height, weight)


                    val args = Bundle()
          /*          args.putString("bmi", result.BMI.toString())
                    args.putString("status", result.status)*/
                    val toResultFragment = HomeFragmentDirections.actionHomeFragment2ToNavigation6().apply {
//                        bmi = result.BMI.toString()
//                        status = result.status
                  /*      bmi = result.BMI.toString()
                        status = result.status*/



                    }





/*                    vm.imt.observe(viewLifecycleOwner, Observer {
                        toResultFragment.bmi = it.BMI.toString()
                    })

                    vm.imt.observe(viewLifecycleOwner, Observer{
                        toResultFragment.status = it.status
                    })*/


//                    findNavController(view).navigate(toResultFragment)
                    val bundle = Bundle().apply {
                        putString("bmi", result.BMI.toString())
                        putString("status", result.status)
                    }
                    findNavController(view).navigate(R.id.action_homeFragment2_to_navigation6, bundle)


                }
            }

        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
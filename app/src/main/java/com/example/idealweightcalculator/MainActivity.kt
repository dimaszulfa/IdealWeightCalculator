package com.example.idealweightcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.idealweightcalculator.databinding.ActivityMainBinding
import com.example.idealweightcalculator.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //    private val viewModel: MainViewModel by viewModel()
    private val vm: MainViewModel by viewModel()


    //    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

/*        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController*/

//        vm.imt.observe(this, Observer {
//            binding.txBMI.text = it.BMI.toString()
//            binding.txStatus.text = it.status
//        })
//
//        binding.btnCalculate.setOnClickListener {
//            var height = binding.edtHeight.text.toString()
//            var weight = binding.edtWeight.text.toString()
//
//            when {
//                height.isEmpty() -> binding.edtHeight.error = "Please input your height"
//                weight.isEmpty() -> binding.edtWeight.error = "Please input your weight"
//                else -> {
////                    viewModel.calculate(height,weight)
//                    vm.calculate(height, weight)
//
//
//                }
//            }
//        }

    }


}
package com.example.idealweightcalculator.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.idealweightcalculator.data.BodyMassDataStore
import com.example.idealweightcalculator.domain.BodyMass
import com.example.idealweightcalculator.domain.DataInteractor
import com.example.idealweightcalculator.domain.DataUseCase

class MainViewModel(private val useCase: DataUseCase) : ViewModel(){
    private val _imt = MutableLiveData<BodyMass>()

    val imt : LiveData<BodyMass>
        get() = _imt




//    val status : LiveData<String> = _status
    fun calculate(height: String, weight: String): BodyMass{
//            val repository = BodyMassDataStore()
//            val dataUseCase = DataInteractor(repository)
            val response = useCase.getCalculate(height, weight)
/*
            _imt.value = response
*/
    return response


    }


}
package com.example.idealweightcalculator.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.idealweightcalculator.data.BodyMassItem
import com.example.idealweightcalculator.data.local.BmiDao
import com.example.idealweightcalculator.domain.BodyMass
import com.example.idealweightcalculator.domain.DataUseCase
import kotlinx.coroutines.*

class MainViewModel(private val useCase: DataUseCase) : ViewModel(){
    private val _imt = MutableLiveData<BodyMass>()

    val imt : LiveData<BodyMass>
        get() = _imt

    private val _bmi = MutableLiveData<List<BodyMass>>()
    val bmi : LiveData<List<BodyMass>>
        get() = _bmi






//    val status : LiveData<String> = _status
    fun calculate(name: String,height: String, weight: String){
//            val repository = BodyMassDataStore()
//            val dataUseCase = DataInteractor(repository)
     viewModelScope.launch(Dispatchers.IO){
            delay(1000)
            _imt.postValue(useCase.getCalculate(name,height, weight))




    }
/*
            _imt.value = response
*/


    }

    fun getAllBmi(){
        viewModelScope.launch(Dispatchers.IO){
            val getData = useCase.getAllBmi()
        /*    withContext(Dispatchers.Main){
                _bmi.value = getData
            }*/
            _bmi.postValue(getData)
//            _bmi.value = getData
            //live data harus di main thread

        }

    }

    fun addBmi(bmi: BodyMass){
        viewModelScope.launch(Dispatchers.IO){
            useCase.addBmi(bmi)
        }
    }

}
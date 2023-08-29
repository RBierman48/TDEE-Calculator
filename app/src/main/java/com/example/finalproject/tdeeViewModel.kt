package com.example.finalproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class tdeeViewModel : ViewModel() {

    val tdeeResult = MutableLiveData<Double>()

    fun calculateTDEE(
        gender: Int,
        age: Int,
        heightInches: Double,
        weightPounds: Double,
        activityLevel: Double
    ):Double {
        val bmr: Double
        val activityFactor:Double = when (activityLevel){
            0.0 -> 1.2
            1.0 -> 1.375
            2.0 -> 1.55
            3.0 -> 1.725
            4.0 -> 1.815
            else -> 1.2
        }

        if(gender == 0){
            bmr = 66 + (6.2 * weightPounds) + (12.7 * heightInches) - (6.76 * age)
        }else{
            bmr = 655.1 + (4.35*weightPounds)+(4.7*heightInches)-(4.7*age)
        }

        val tdee = bmr * activityFactor

        return tdee

    }


}
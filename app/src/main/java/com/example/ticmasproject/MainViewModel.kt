package com.example.ticmasproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val result = MutableLiveData<String>()

    fun compareTexts(text1: String, text2: String) {
        if (text1 == text2) {
            result.value = "Las cadenas son iguales"
        } else {
            result.value = "Las cadenas son diferentes"
        }
    }

}

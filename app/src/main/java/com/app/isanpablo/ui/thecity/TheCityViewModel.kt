package com.app.isanpablo.ui.thecity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TheCityViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is The City Fragment"
    }
    val text: LiveData<String> = _text
}
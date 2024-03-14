package com.app.isanpablo.ui.government

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GovernmentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Government Fragment"
    }
    val text: LiveData<String> = _text
}
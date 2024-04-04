package com.app.isanpablo.ui.arta

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ARTAViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Economy Fragment"
    }
    val text: LiveData<String> = _text
}
package com.example.asha_inventario.ui.eliminar_productos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EliminarProductosViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _text = MutableLiveData<String>().apply {
        value = "Este es la pantalla Eliminar productos"
    }
    val text: LiveData<String> = _text
}
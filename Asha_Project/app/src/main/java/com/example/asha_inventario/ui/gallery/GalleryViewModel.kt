package com.example.asha_inventario.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Pantalla o Fragment de Crear productos"
    }
    val text: LiveData<String> = _text
}
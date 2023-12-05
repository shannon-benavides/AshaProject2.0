package com.example.asha_inventario.ui.gallery

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.navigation.fragment.findNavController
import com.example.asha_inventario.databinding.FragmentGalleryBinding
import com.example.asha_inventario.R

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    var txtDate_fechaVencimiento : EditText ?= null
    var button_FechaVencimiento : ImageButton ?= null
    var datePicker_fechaVencimiento : DatePicker ?= null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

            _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val button_tomarFoto = root.findViewById<Button>(R.id.button_tomarFoto)
        val button_subirImagen = root.findViewById<Button>(R.id.button_subirImagen)
        val imagen_subida = root.findViewById<ImageView>(R.id.imagen_crear_producto)

        val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result: ActivityResult ->
            if(result.resultCode == Activity.RESULT_OK){
                val intent = result.data
                val imageBitMap = intent?.extras?.get("data") as Bitmap
                val imageView = root.findViewById<ImageView>(R.id.imagen_crear_producto)
                imageView.setImageBitmap(imageBitMap)
            }
        }


        /*val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

        // Fecha de Vencimiento funciones
        txtDate_fechaVencimiento = root.findViewById(R.id.txtDate_fechaVencimiento)
        button_FechaVencimiento = root.findViewById(R.id.button_fecha_vencimiento)
        datePicker_fechaVencimiento = root.findViewById(R.id.datePicker_fechaVencimiento)

        txtDate_fechaVencimiento?.setText(getFechaDatePicker())

        button_FechaVencimiento?.setOnClickListener {
            muestraCalendario(root)
        }

        datePicker_fechaVencimiento?.setOnDateChangedListener{
            datePicker_fechaVencimiento, anio, mes, dia->
            txtDate_fechaVencimiento?.setText(getFechaDatePicker())
            datePicker_fechaVencimiento?.visibility = View.GONE
        }


        //Camara funciones
        button_tomarFoto.setOnClickListener {
            startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }

        //Subir imagen funciones
        button_subirImagen.setOnClickListener{
            cargarImgSubirImg()
        }


        return root
    }

    private fun cargarImgSubirImg() {
        val intent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.setType("image/")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getFechaDatePicker():String{
        var dia = datePicker_fechaVencimiento?.dayOfMonth.toString().padStart(2, '0')
        var mes = (datePicker_fechaVencimiento!!.month + 1).toString().padStart(2, '0')
        var anio = datePicker_fechaVencimiento?.year.toString().padStart(4, '0')

        return "$dia/$mes/$anio"
    }

    fun muestraCalendario(view: View){
        datePicker_fechaVencimiento?.visibility = View.VISIBLE
    }


}
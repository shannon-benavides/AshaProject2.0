package com.example.asha_inventario.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.asha_inventario.R
import com.example.asha_inventario.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var btn_crear: ImageButton
    private lateinit var btn_actualizar: ImageButton
    private lateinit var btn_eliminar: ImageButton
    private lateinit var btn_ver_productos: ImageButton
    private lateinit var btn_busqueda: ImageButton
    private lateinit var btn_categoria: ImageButton
    private lateinit var btn_configuracion: ImageButton
    private lateinit var btn_codigo_QR: ImageButton


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        //animaciones
        val rotateAnimation = AnimationUtils.loadAnimation(context, androidx.constraintlayout.widget.R.anim.abc_fade_in)
        val clickAnimation = AnimationUtils.loadAnimation(context, androidx.constraintlayout.widget.R.anim.abc_popup_exit)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        btn_crear = root.findViewById(R.id.btn_crearproducto)
        btn_actualizar = root.findViewById(R.id.btn_actualizarproducto)
        btn_eliminar = root.findViewById(R.id.btn_eliminarproducto)
        btn_ver_productos = root.findViewById(R.id.btn_verproductos)
        btn_categoria = root.findViewById(R.id.btn_categorias)
        btn_busqueda = root.findViewById(R.id.btn_busqueda)
        btn_codigo_QR = root.findViewById(R.id.btn_lectorcodigobarras)
        btn_configuracion = root.findViewById(R.id.btn_configuracion)

        btn_crear.startAnimation(rotateAnimation)
        btn_actualizar.startAnimation(rotateAnimation)
        btn_eliminar.startAnimation(rotateAnimation)
        btn_ver_productos.startAnimation(rotateAnimation)
        btn_busqueda.startAnimation(rotateAnimation)
        btn_categoria.startAnimation(rotateAnimation)
        btn_configuracion.startAnimation(rotateAnimation)
        btn_codigo_QR.startAnimation(rotateAnimation)

        btn_crear.setOnClickListener(){
            btn_crear.startAnimation(clickAnimation)
            Toast.makeText(activity, "Crear Producto/item", Toast.LENGTH_LONG).show()
        }

        btn_actualizar.setOnClickListener(){
            btn_actualizar.startAnimation(clickAnimation)
            Toast.makeText(activity, "Actualizar productos", Toast.LENGTH_SHORT).show()
        }

        btn_eliminar.setOnClickListener(){
            btn_eliminar.startAnimation(clickAnimation)
            Toast.makeText(activity, "Eliminar productos", Toast.LENGTH_SHORT).show()
        }

        btn_ver_productos.setOnClickListener(){
            btn_ver_productos.startAnimation(clickAnimation)
            Toast.makeText(activity, "Listado de productos", Toast.LENGTH_SHORT).show()
        }

        btn_categoria.setOnClickListener(){
            btn_categoria.startAnimation(clickAnimation)
            Toast.makeText(activity, "Categorias por producto", Toast.LENGTH_SHORT).show()
        }

        btn_busqueda.setOnClickListener(){
            btn_busqueda.startAnimation(clickAnimation)
            Toast.makeText(activity, "Busqueda de Productos", Toast.LENGTH_SHORT).show()
        }

        btn_configuracion.setOnClickListener(){
            btn_configuracion.startAnimation(clickAnimation)
            Toast.makeText(activity, "Configuracion", Toast.LENGTH_SHORT).show()
        }

        btn_codigo_QR.setOnClickListener(){
            btn_codigo_QR.startAnimation(clickAnimation)
            Toast.makeText(activity, "Lector QR", Toast.LENGTH_SHORT).show()
        }

/*        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
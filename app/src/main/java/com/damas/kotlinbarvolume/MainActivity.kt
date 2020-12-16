package com.damas.kotlinbarvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object{
        private const val STATE_RESULT= "state_result"
    }

    private lateinit var etPanjang: EditText
    private lateinit var etLebar:EditText
    private lateinit var etTinggi: EditText
    private lateinit var btnHitung :Button
    private lateinit var tvHasil: TextView

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvHasil.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPanjang = findViewById(R.id.et_panjang)
        etLebar = findViewById(R.id.et_lebar)
        etTinggi = findViewById(R.id.et_tinggi)
        btnHitung= findViewById(R.id.btn_hitung)
        tvHasil = findViewById(R.id.tv_hasil)

        if (savedInstanceState !=null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvHasil.text= result
        }

       btnHitung.setOnClickListener {
           val inputPanjang = etPanjang.text.toString().trim()
           val inputLebar = etLebar.text.toString().trim()
           val inputTinggi = etTinggi.text.toString().trim()

           var isEmptyFields = false


           when{
               inputPanjang.isEmpty() ->{
                   isEmptyFields = true
                   etPanjang.error= " Field stidak boleh kosong"
               }
               inputLebar.isEmpty() ->{
                   isEmptyFields= true
                   etLebar.error= "Field tidak boleh kosong"
               }
               inputTinggi.isEmpty()->{
                   isEmptyFields = true
                   etTinggi.error= "Field tidak boleh kosong"
               }
           }
           if (!isEmptyFields){
               val volume = inputPanjang.toDouble()*inputLebar.toDouble()*inputTinggi.toDouble()
               //tvHasil.text= getString()+" = "+volume.toString()
               tvHasil.text = getString(R.string.tv_hasil) +" = "+ volume.toString()
           }
       }

    }
}
package com.example.pertintent

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class actIntent4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_act_intent4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intentPegawai = intent.getParcelableExtra(dataPegawai, Pegawai::class.java)
        val isiText = "NIP : ${intentPegawai?.NIP.toString()}, " + "\nNama : ${intentPegawai?.Nama.toString()}, " + "\nDept : ${intentPegawai?.Dept.toString()}"

        val _getDataPegawai = findViewById<TextView>(R.id.getDataPegawai)
        _getDataPegawai.text = isiText
    }

    companion object {
        val dataPegawai = "kirimDataPegawai"
    }
}
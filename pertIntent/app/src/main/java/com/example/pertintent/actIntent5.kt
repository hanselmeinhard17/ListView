package com.example.pertintent

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class actIntent5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_act_intent5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intentPegawai = intent.getParcelableArrayListExtra(dataPegawai, Pegawai::class.java)
        val isiText = "NIP : ${intentPegawai!![0].NIP.toString()}, " + "\nNama : ${intentPegawai!![0].Nama.toString()}, " + "\nDept : ${intentPegawai!![0].Dept.toString()}" +
                "\n" +
                "\nNIP : ${intentPegawai?.get(1)?.NIP.toString()}, " + "\nNama : ${intentPegawai?.get(1)?.Nama.toString()}, " + "\nDept : ${intentPegawai?.get(1)?.Dept.toString()}"

        val _getDataPegawai = findViewById<TextView>(R.id.getDataPegawai)
        _getDataPegawai.text = isiText
    }

    companion object {
        val dataPegawai = "kirimDataPegawai"
    }
}
package com.example.latihanawal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.i("APLIKASI-AWAL","onCreate Berjalan")

        val _button = findViewById<Button>(R.id.button)
        _button.setOnClickListener {
            val _alert = AlertDialog.Builder(this)
                .setTitle("Warning")
                .setMessage("Coba Alert Dialog")
                .setPositiveButton("OK") {
                    dialog, which ->
                        dialog.dismiss()
                }
                .create()
            _alert.show()
        }

        val _button2 = findViewById<Button>(R.id.button2)
        _button2.setOnClickListener {
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("APLIKASI-AWAL","onStart Berjalan")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("APLIKASI-AWAL","onRestart Berjalan")
    }

    override fun onResume() {
        super.onResume()
        Log.i("APLIKASI-AWAL","onResume Berjalan")
    }

    override fun onPause() {
        super.onPause()
        Log.i("APLIKASI-AWAL","onPause Berjalan")
    }

    override fun onStop() {
        super.onStop()
        Log.i("APLIKASI-AWAL","onStop Berjalan")
    }
}
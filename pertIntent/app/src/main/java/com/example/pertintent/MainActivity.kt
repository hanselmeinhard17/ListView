package com.example.pertintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
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

        var _btnExplisit1 = findViewById<Button>(R.id.btnExplisit1)
        _btnExplisit1.setOnClickListener {
            val intent = Intent(this@MainActivity, actIntent2::class.java)
            startActivity(intent)
        }

        var _edtExplisit = findViewById<EditText>(R.id.edtExplisit)
        var _btnExplisit2 = findViewById<Button>(R.id.btnExplisit2)
        _btnExplisit2.setOnClickListener {
            val intentWithData = Intent(this@MainActivity, actIntent3::class.java).apply {
                putExtra(actIntent3.dataTerima, _edtExplisit.text.toString() )
            }
            startActivity(intentWithData)
        }

        val isiPegawai = Pegawai(1,"Anita","Test")

        var _btnExplisit3 = findViewById<Button>(R.id.btnExplisit3)
        _btnExplisit3.setOnClickListener {
            val intentWithData = Intent(this@MainActivity,actIntent4::class.java).apply {
                putExtra(actIntent4.dataPegawai,isiPegawai)
            }
            startActivity(intentWithData)
        }

        val isiPegawai4 : ArrayList<Pegawai> = arrayListOf()

        isiPegawai4.add(Pegawai(1,"Anita","Test"))
        isiPegawai4.add(Pegawai(2,"Tatik","Marketing"))

        var _btnExplisit4 = findViewById<Button>(R.id.btnExplisit4)
        _btnExplisit4.setOnClickListener {
            val intentWithData = Intent(this@MainActivity,actIntent5::class.java).apply {
                putExtra(actIntent5.dataPegawai,isiPegawai4)
            }
            startActivity(intentWithData)
        }
    }
}
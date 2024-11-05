package uts.c14220233.app

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class tabungan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tabungan)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intentData = intent.getParcelableExtra<Isian>("isian", Isian::class.java)
        val _tvTotal = findViewById<TextView>(R.id.tvTotal)
        val _etTambah = findViewById<EditText>(R.id.etTambah)

        if (intentData != null) {
            _tvTotal.text = intentData.Total.toString()
            _etTambah.setText("0")
        }

        val _btnOK = findViewById<TextView>(R.id.btnOK)
        _btnOK.setOnClickListener {
            var _totalUang = (_tvTotal.text.toString().replace(".","")).toLong() + _etTambah.text.toString().toLong()

            val dataKirim = Isian(_totalUang)

            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("isian", dataKirim)
            }
            startActivity(intent)
            finish()
        }
    }
}
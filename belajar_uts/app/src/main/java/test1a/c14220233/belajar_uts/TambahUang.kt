package test1a.c14220233.belajar_uts

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TambahUang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tambah_uang)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intentData = intent.getParcelableExtra<Isian>("isian", Isian::class.java)
        val _tvTotal = findViewById<TextView>(R.id.tvTotal)
        val _tvTotalKategori = findViewById<TextView>(R.id.tvTotalKategori)
        val _etTambah = findViewById<EditText>(R.id.etTambah)
        val _tvKategori = findViewById<TextView>(R.id.tvKategori)
        var _batas = "0"

        if (intentData != null) {
            _tvTotal.text = intentData.Total.toString()
            _tvTotalKategori.text = intentData.TotalKategori.toString()
            _etTambah.setText("0")
            _batas = intentData.BatasKategori.toString()
        }

        val _btnOK = findViewById<TextView>(R.id.btnOK)
        _btnOK.setOnClickListener {
            var _totalUang = (_tvTotal.text.toString().replace(".","")).toLong() + _etTambah.text.toString().toLong()
            var _totalKategori = (_tvTotalKategori.text.toString().replace(".","")).toLong()+_etTambah.text.toString().toLong()

            val dataKirim = Isian(_totalUang, _batas.toLong(), _totalKategori, "1")

            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("isian", dataKirim)
            }
            startActivity(intent)
            finish()
        }
    }
}
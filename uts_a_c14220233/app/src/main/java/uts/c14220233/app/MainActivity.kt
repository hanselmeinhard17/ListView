package uts.c14220233.app

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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

        var _btnEmail = findViewById<Button>(R.id.btnEmail)
        _btnEmail.setOnClickListener {
            val intent = Intent(this@MainActivity, email::class.java)
            startActivity(intent)
        }

        var _btnCall = findViewById<Button>(R.id.btnCall)
        _btnCall.setOnClickListener {
            val _sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra("address", "087703004065")
                putExtra("sms_body", "ISI SMS")
                type = "text/plain"
            }

            if (_sendIntent.resolveActivity(packageManager) != null) {
                startActivity(Intent.createChooser(_sendIntent, "PILIH APLIKASI"))
            }
        }

        var _btnKuliah = findViewById<Button>(R.id.btnKuliah)
        _btnKuliah.setOnClickListener {
            val intent = Intent(this@MainActivity, jadwal_kuliah::class.java)
            startActivity(intent)
        }

        val _tvTotalUang = findViewById<TextView>(R.id.tvTotalUang)

        var _btnUang = findViewById<Button>(R.id.btnUang)
        _btnUang.setOnClickListener {
            var _totalUang = (_tvTotalUang.text.toString().replace(".", "")).toLong()

            val dataKirim = Isian(_totalUang)

            val intent = Intent(this, tabungan::class.java).apply {
                putExtra("isian", dataKirim)
            }
            startActivity(intent)
        }

        val intentData = intent.getParcelableExtra<Isian>("isian", Isian::class.java)

        if (intentData != null) {
            _tvTotalUang.setText(intentData.Total.toString())
        }
    }
}
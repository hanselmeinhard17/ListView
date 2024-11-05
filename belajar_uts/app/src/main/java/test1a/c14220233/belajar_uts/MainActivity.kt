package test1a.c14220233.belajar_uts

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DecimalFormat

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

        val _tvTotalUang = findViewById<TextView>(R.id.tvTotalUang)
        val _tvBatasKat = findViewById<TextView>(R.id.tvBatasKat)
        val _tvIsiItem = findViewById<TextView>(R.id.tvIsiItem)
        val _tvIsiPersen = findViewById<TextView>(R.id.tvIsiPersen)

        val _btnTambah = findViewById<TextView>(R.id.btnTambah)
        _btnTambah.setOnClickListener {
            var _totalUang = (_tvTotalUang.text.toString().replace(".", "")).toLong()
            var _batasKat = (_tvBatasKat.text.toString().replace(".", "")).toLong()
            var _isiItem = (_tvIsiItem.text.toString().replace(".", "")).toLong()
            var _isiPersen = _tvIsiPersen.text.toString()

            val dataKirim = Isian(_totalUang, _batasKat, _isiItem, "1")

            val intent = Intent(this, TambahUang::class.java).apply {
                putExtra("isian", dataKirim)
            }
            startActivity(intent)
            finish()
        }

        val intentData = intent.getParcelableExtra<Isian>("isian", Isian::class.java)

        if (intentData != null) {
            _tvTotalUang.setText(intentData.Total.toString())
            _tvIsiItem.setText(intentData.TotalKategori.toString())
            val df = DecimalFormat("#.##")
            var hitung = _tvIsiItem.text.toString().replace(".", "")
                .toDouble() / (_tvBatasKat.text.toString().replace(".", "")).toDouble() * 100
            _tvIsiPersen.setText("  (${df.format(hitung).toString()}% left)")
        }
    }
}

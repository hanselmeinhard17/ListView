package test1a.c14220233.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class halaman2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_halaman2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var _btnkembali = findViewById<Button>(R.id.btnKembali)
        _btnkembali.setOnClickListener {
            val intent = Intent(this@halaman2, MainActivity::class.java)
            startActivity(intent)
        }

        var _edtText = findViewById<EditText>(R.id.edtText)
        var _btnkirimuang = findViewById<Button>(R.id.btnKirimUang)
        _btnkirimuang.setOnClickListener {
            val intentWithData = Intent(this@halaman2, MainActivity::class.java).apply {
                putExtra(MainActivity.dataTerima, _edtText.text.toString() )
            }
            startActivity(intentWithData)
        }
    }
}
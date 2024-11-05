package uts.c14220233.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class email : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_email)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var _btn1 = findViewById<Button>(R.id.sendMessage)
        var _body = findViewById<EditText>(R.id.bodyEmail)
        _btn1.setOnClickListener {
            val _sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra("address", "c14220233@john.petra.ac.id")
                putExtra(Intent.EXTRA_TEXT,_body.getText().toString())
                type = "text/plain"
            }

            if (_sendIntent.resolveActivity(packageManager) != null) {
                startActivity(Intent.createChooser(_sendIntent, "PILIH APLIKASI"))
            }
        }
    }
}
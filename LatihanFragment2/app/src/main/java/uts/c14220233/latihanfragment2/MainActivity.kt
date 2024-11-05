package uts.c14220233.latihanfragment2

import android.os.Bundle
import android.widget.Button
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

        val mFragmentManager = supportFragmentManager

        mFragmentManager.findFragmentByTag(fHalSatu::class.java.simpleName)
        mFragmentManager
            .beginTransaction()
            .replace(R.id.frameContainer, fHalSatu(), fHalSatu::class.java.simpleName)
            .commit()

        val _btn1 = findViewById<Button>(R.id.hal1)
        _btn1.setOnClickListener {
            if (alphabet.equals('Z')) alphabet = 'A' else alphabet++
            mFragmentManager.findFragmentByTag(fHalSatu::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .replace(R.id.frameContainer, fHalSatu(), fHalSatu::class.java.simpleName)
                .commit()
        }

        val _btn2 = findViewById<Button>(R.id.hal2)
        _btn2.setOnClickListener {
            if (alphabet.equals('Z')) alphabet = 'A' else alphabet++
            mFragmentManager.findFragmentByTag(fHalDua::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .replace(R.id.frameContainer, fHalDua(), fHalDua::class.java.simpleName)
                .commit()
        }

        val _btn3 = findViewById<Button>(R.id.hal3)
        _btn3.setOnClickListener {
            if (alphabet.equals('Z')) alphabet = 'A' else alphabet++
            mFragmentManager.findFragmentByTag(fHalTiga::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .replace(R.id.frameContainer, fHalTiga(), fHalTiga::class.java.simpleName)
                .commit()
        }
    }

    companion object {
        var alphabet = 'A'
    }
}
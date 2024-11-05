package test1a.c14220233.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import test1a.c14220233.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        var _btn1 = findViewById<Button>(R.id.button1)
        _btn1.setOnClickListener {
            val intent = Intent(this@MainActivity, halaman2::class.java)
            startActivity(intent)
        }

        var _btn2 = findViewById<Button>(R.id.button2)
        _btn2.setOnClickListener {
            val intent = Intent(this@MainActivity, halaman2::class.java)
            startActivity(intent)
        }

        var _btn3 = findViewById<Button>(R.id.button3)
        _btn3.setOnClickListener {
            val intent = Intent(this@MainActivity, halaman2::class.java)
            startActivity(intent)
        }

        val data = intent.getStringExtra(dataTerima)

        val _showData1 = findViewById<TextView>(R.id.textview1)
        _showData1.text = data?.toString()

        val _showData2 = findViewById<TextView>(R.id.textview2)
        _showData2.text = data?.toString()

        val _showData3 = findViewById<TextView>(R.id.textview3)
        _showData3.text = data?.toString()
    }

    companion object {
        const val dataTerima = "GETDATA"
    }
}
package lat.fraggame

import android.os.Bundle

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.frameContainer)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val mFragmentManager = supportFragmentManager


        val mfHalaman1 = Fragment_Hal1()
        mFragmentManager.findFragmentByTag(Fragment_Hal1::class.java.simpleName)
        mFragmentManager
            .beginTransaction()
            .add(R.id.frameContainer, mfHalaman1, Fragment_Hal1::class.java.simpleName)
            .commit()


        val _botNavView = findViewById<BottomNavigationView>(R.id.bottomNav)
        _botNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.game_menu -> {
                    mFragmentManager
                        .beginTransaction()
                        .add(
                            R.id.frameContainer,
                            Fragment_Hal1(),
                            Fragment_Hal1::class.java.simpleName
                        )
                        .commit()
                    return@setOnItemSelectedListener true
                }

                R.id.score_menu -> {
                    mFragmentManager
                        .beginTransaction()
                        .add(
                            R.id.frameContainer,
                            Fragment_Hal2(),
                            Fragment_Hal2::class.java.simpleName
                        )
                        .commit()
                    return@setOnItemSelectedListener true
                }

                R.id.setting_menu -> {
                    mFragmentManager
                        .beginTransaction()
                        .add(
                            R.id.frameContainer,
                            Fragment_Hal3(),
                            Fragment_Hal3::class.java.simpleName
                        )
                        .commit()
                    return@setOnItemSelectedListener true
                }

                else -> {
                    return@setOnItemSelectedListener false
                }
            }
        }


    }


    companion object {
        var playerScore = PlayerScore(50)
    }
}
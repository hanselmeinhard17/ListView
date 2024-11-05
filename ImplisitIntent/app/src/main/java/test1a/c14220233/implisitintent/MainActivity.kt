package test1a.c14220233.implisitintent

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.icu.util.Calendar
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CalendarContract
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.net.URL
import java.text.SimpleDateFormat

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

        var _btn1 = findViewById<Button>(R.id.sendMessage)
        _btn1.setOnClickListener {
            val _sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra("address", "08112345")
                putExtra("sms_body", "ISI SMS")
                type = "text/plain"
            }

            if (_sendIntent.resolveActivity(packageManager) != null) {
                startActivity(Intent.createChooser(_sendIntent, "PILIH APLIKASI"))
            }
        }

        var _btn2 = findViewById<Button>(R.id.alarmbutton)
        _btn2.setOnClickListener {
            val _alarmIntent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "COBA ALARM")
                putExtra(AlarmClock.EXTRA_HOUR, 11)
                putExtra(AlarmClock.EXTRA_MINUTES, 40)
                putExtra(AlarmClock.EXTRA_SKIP_UI, true)
            }
            startActivity(_alarmIntent)
        }

        var _btn2b = findViewById<Button>(R.id.settimer)
        _btn2b.setOnClickListener {
            val _timerIntent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "COBA TIMER")
                putExtra(AlarmClock.EXTRA_LENGTH, 40)
                putExtra(AlarmClock.EXTRA_SKIP_UI, true)
            }
            startActivity(_timerIntent)
        }

        var _btn3 = findViewById<Button>(R.id.openwebsite)
        var _tvAlamat = findViewById<EditText>(R.id.tvAlamat)
        _btn3.setOnClickListener {
            val _webIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://" + _tvAlamat.text.toString())
            )

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(_webIntent)
            }
        }

        val _WaktuAwal: Long = Calendar.getInstance().run {
            set(2023, 9, 19, 7, 30)
            timeInMillis
        }
        val _WaktuAkhir: Long = Calendar.getInstance().run {
            set(2023, 9, 20, 7, 30)
            timeInMillis
        }
        var _btn4 = findViewById<Button>(R.id.calenderbutton)
        _btn4.setOnClickListener {
            val _eventIntent = Intent(Intent.ACTION_INSERT).apply {
                data = CalendarContract.Events.CONTENT_URI
                putExtra(CalendarContract.Events.TITLE, title)
                putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, _WaktuAwal)
                putExtra(CalendarContract.EXTRA_EVENT_END_TIME, _WaktuAkhir)
            }
            startActivity(_eventIntent)
        }

        var _btn5 = findViewById<Button>(R.id.camerabutton)
        _btn5.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, pic_id)
        }


        var alarmButton = findViewById<Button>(R.id.implisitalarm)
        var inputHour = findViewById<EditText>(R.id.input_hour)
        var inputMinute = findViewById<EditText>(R.id.input_minute)
        var inputAlarmMessage = findViewById<EditText>(R.id.input_alarm_message)
        alarmButton.setOnClickListener {
            val hour = inputHour.text.toString().toIntOrNull()
            val minute = inputMinute.text.toString().toIntOrNull()
            val message = inputAlarmMessage.text.toString()

            if (hour != null && minute != null) {
                val alarmIntent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                    putExtra(AlarmClock.EXTRA_MESSAGE, message)
                    putExtra(AlarmClock.EXTRA_HOUR, hour)
                    putExtra(AlarmClock.EXTRA_MINUTES, minute)
                    putExtra(AlarmClock.EXTRA_SKIP_UI, true)
                }
                startActivity(alarmIntent)
            }
        }

        var calendarButton = findViewById<Button>(R.id.calendar)
        var inputTitle = findViewById<EditText>(R.id.input_title)
        var inputEmail = findViewById<EditText>(R.id.input_email)
        var inputStartDate = findViewById<EditText>(R.id.input_start_date)
        var inputEndDate = findViewById<EditText>(R.id.input_end_date)
        var inputDescription = findViewById<EditText>(R.id.input_description)

        calendarButton.setOnClickListener {
            val title = inputTitle.text.toString()
            val email = inputEmail.text.toString()
            val description = inputDescription.text.toString()
            val startDateStr = inputStartDate.text.toString()
            val endDateStr = inputEndDate.text.toString()

            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            val startDate = dateFormat.parse(startDateStr)?.time
            val endDate = dateFormat.parse(endDateStr)?.time

            if (startDate != null && endDate != null) {
                val eventIntent = Intent(Intent.ACTION_INSERT).apply {
                    data = CalendarContract.Events.CONTENT_URI
                    putExtra(CalendarContract.Events.TITLE, title)
                    putExtra(CalendarContract.Events.DESCRIPTION, description)
                    putExtra(CalendarContract.Events.EVENT_LOCATION, "Online")
                    putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startDate)
                    putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endDate)
                    putExtra(Intent.EXTRA_EMAIL, email)
                }
                startActivity(eventIntent)
            }
        }
    }

    companion object {
        private const val pic_id = 123
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val _tampilPic = findViewById<ImageView>(R.id.tampilpic)
        if (requestCode == pic_id && resultCode == Activity.RESULT_OK) {
            val photo: Bitmap = data!!.extras!!.get("data") as Bitmap
            _tampilPic!!.setImageBitmap(photo)
        }
    }
}
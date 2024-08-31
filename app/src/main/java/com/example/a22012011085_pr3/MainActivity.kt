package com.example.a22012011085_pr3
import android.provider.AlarmClock
import android.provider.MediaStore
import android.provider.Telephony.Mms.Intents
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


import android.content.Intent
import android.net.Uri



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
        val urlbtn = findViewById<Button>(R.id.browse)
        val url = findViewById<EditText>(R.id.urlInput)
        urlbtn.setOnClickListener{
            val urlIntent = Intent(Intent.ACTION_VIEW)
            urlIntent.setData(android.net.Uri.parse(url.text.toString()))
            startActivity(urlIntent)
        }
        val phonebtn = findViewById<Button>(R.id.call)
        val phoneInput = findViewById<EditText>(R.id.phoneInput)
        phonebtn.setOnClickListener{
            val phoneNumber = phoneInput.text.toString()
            val phoneIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(phoneIntent)
        }
        val callLog = findViewById<Button>(R.id.callLog)
        callLog.setOnClickListener{
            val clIntent = Intent(Intent.ACTION_VIEW)
            clIntent.setData(android.net.Uri.parse("content://call_log/calls"))
            startActivity(clIntent)
        }
        val gallary = findViewById<Button>(R.id.gallary)
        gallary.setOnClickListener{
            val gIntent = Intent(Intent.ACTION_VIEW).apply{
                type="image/*"
            }
            startActivity(gIntent)
        }
        val camera = findViewById<Button>(R.id.camera)
        camera.setOnClickListener{
            val cIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(cIntent)
        }
        val alarm = findViewById<Button>(R.id.alarm)
        alarm.setOnClickListener{
            val aIntent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
            startActivity(aIntent)
        }
        val loginBtn = findViewById<Button>(R.id.login)
        loginBtn.setOnClickListener{
            Intent(this, LoginActivity::class.java)
                .putExtra("email","nishupatel@gmail.com")
                .putExtra("password","1234567")
                .also{
                    startActivity(it)
                }
        }
    }
}
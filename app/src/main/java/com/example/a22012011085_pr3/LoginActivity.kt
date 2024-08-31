package com.example.a22012011085_pr3
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val email = intent.getStringExtra("email").toString()
        val password = intent.getStringExtra("password").toString()
        Log.i("email",email)
        Log.i("password", password)
        val emailIn = findViewById<EditText>(R.id.emailInput)
        val passwordIn = findViewById<EditText>(R.id.passwordInput)
        val loginMain = findViewById<Button>(R.id.button8)
        loginMain.setOnClickListener{

        }
    }
}
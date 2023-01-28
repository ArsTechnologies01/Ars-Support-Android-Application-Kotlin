package com.example.arstrack.activity

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import android.os.Bundle
import android.content.Intent
import android.view.View
import com.example.arstrack.R

class LoginActivity : AppCompatActivity() {
    var phoneNum: TextInputEditText? = null
    var password: TextInputEditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /* ---------------Hooks-----------*/

        phoneNum = findViewById(R.id.loginPhoneNum)
        password = findViewById(R.id.loginPassword)

        /* ---------onClick to signUp Btn------------*/

        findViewById<View>(R.id.signUpAcc).setOnClickListener {
            startActivity(
                Intent(this@LoginActivity, SignUpActivity::class.java)
            )
        }

        /* ---------Login Button------------*/

        findViewById<View>(R.id.loginButton).setOnClickListener {
            startActivity(
                Intent(this@LoginActivity, MainActivity::class.java)
            )
        }
    }
}
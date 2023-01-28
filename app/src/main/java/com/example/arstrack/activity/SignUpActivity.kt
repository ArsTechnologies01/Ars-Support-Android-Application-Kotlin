package com.example.arstrack.activity

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import android.os.Bundle
import android.content.Intent
import android.view.View
import com.example.arstrack.R


class SignUpActivity : AppCompatActivity() {

    var fullName: TextInputEditText? = null
    var email: TextInputEditText? = null
    var phoneNumber: TextInputEditText? = null
    var password: TextInputEditText? = null
    var confirmPassword: TextInputEditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        /* ---------------Hooks-----------*/

        fullName = findViewById(R.id.signUpFullName)
        email = findViewById(R.id.signUpEmail)
        phoneNumber = findViewById(R.id.signUpPhoneNum)
        password = findViewById(R.id.signUpPassword)
        confirmPassword = findViewById(R.id.signUpConfirmPassword)

        /* ---------onClick to login Btn------------*/

        findViewById<View>(R.id.loginAcc).setOnClickListener {
            val intentLogin = Intent(this, LoginActivity::class.java)
            startActivity(intentLogin)
        }

        /* ---------SignUp Button------------*/

        findViewById<View>(R.id.signUpButton).setOnClickListener(
            View.OnClickListener {
                startActivity(Intent(this, MainActivity::class.java))
            })

    }
}
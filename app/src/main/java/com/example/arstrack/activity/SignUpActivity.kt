package com.example.arstrack.activity

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import android.os.Bundle
import android.content.Intent
import android.util.Patterns
import android.view.View
import com.example.arstrack.R
import com.google.android.material.textfield.TextInputLayout
import java.util.*


class SignUpActivity : AppCompatActivity() {

    private var fullName: TextInputEditText? = null
    private var email: TextInputEditText? = null
    private var phoneNumber: TextInputEditText? = null
    private var password: TextInputEditText? = null
    private var confirmPassword: TextInputEditText? = null


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

                if (!validateName() or !validateEmail() or !validatePhoneNumber() or !validatePassword() or !validateConfirmPassword()) {
                    return@OnClickListener
                }
                if (Objects.requireNonNull(password?.text)
                        .toString() != Objects.requireNonNull(
                        confirmPassword?.text
                    ).toString()
                ) {
                    val passwordLayout =
                        findViewById<TextInputLayout>(R.id.confirmPasswordEditTextLayout)
                    passwordLayout.error = "Password does not match"
                    return@OnClickListener
                }
                startActivity(Intent(this, MainActivity::class.java))
            })
    }

    /* ------------SignUp Details validation----------------*/
    private fun validateName(): Boolean {
        val `val` = Objects.requireNonNull(fullName!!.text).toString()
        if (`val`.isEmpty()) {
            fullName!!.error = "Field cannot be empty!"
            return false
        }
        return true
    }

    private fun validateEmail(): Boolean {
        val `val` = Objects.requireNonNull(email!!.text).toString()
        if (`val`.isEmpty()) {
            email!!.error = "Cannot be empty!"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(`val`).matches()) {
            email!!.error = "Enter valid email"
            return false
        }
        return true
    }

    private fun validatePhoneNumber(): Boolean {
        val `val` = Objects.requireNonNull(phoneNumber!!.text).toString()
        if (`val`.isEmpty()) {
            phoneNumber!!.error = "Cannot be empty"
            return false
        }
        return true
    }

    private fun validatePassword(): Boolean {
        val passwordLayout = findViewById<TextInputLayout>(R.id.passwordEditTextLayout)
        val `val` = Objects.requireNonNull(passwordLayout.editText)?.text.toString()
        val passwordMatcher = "^" + "(?=.*[@#$%^&+=])" +  // at least 1 special character
                "(?=\\S+$)" +  // no white spaces
                ".{4,}" +  // at least 4 characters
                "$"
        if (`val`.isEmpty()) {
            passwordLayout.error = "Cannot be empty!"
            return false
        }
        passwordLayout.isErrorEnabled = false
        return true
    }

    private fun validateConfirmPassword(): Boolean {
        val passwordLayout = findViewById<TextInputLayout>(R.id.confirmPasswordEditTextLayout)
        val `val` = Objects.requireNonNull(passwordLayout.editText)?.text.toString()
        if (`val`.isEmpty()) {
            passwordLayout.error = "Cannot be empty!"
            return false
        }
        passwordLayout.isErrorEnabled = false
        return true
    }
}
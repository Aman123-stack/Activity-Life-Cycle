package com.internshala.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {


    lateinit var etMobilePassword: EditText
    lateinit var etMobileNumber: EditText
    lateinit var btnLogin: Button
    lateinit var txtRegister: TextView
    lateinit var txtForgotPassword: TextView
    val validMobileNo = "9937800632"
    val validPassword = arrayOf("tony", "steve","thor","bruce")
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)
        setContentView(R.layout.activity_new)
        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)
        if (isLoggedIn){
            val intent=Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
             finish()
        }


        title = "Log In"
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etMobilePassword = findViewById(R.id.etMobilePassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtRegister = findViewById(R.id.txtRegister)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        btnLogin.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()
            val Password = etMobilePassword.text.toString()
            var nameofavenger = "Avenger"
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            if ((mobileNumber == validMobileNo)) {
                if (Password == validPassword[0]) {
                    nameofavenger = "Iron Man"
                    savepreferences(nameofavenger)
                    startActivity(intent)
                } else if (Password == validPassword[1]) {
                    nameofavenger = "Captain America"
                    savepreferences(nameofavenger)
                   startActivity(intent)
                } else if (Password == validPassword[2]) {
                    nameofavenger = "Hulk"
                    savepreferences(nameofavenger)
                    startActivity(intent)
                } else if (Password == validPassword[3]) {
                    nameofavenger = "Avengers"
                    savepreferences(nameofavenger)
                    startActivity(intent)

                } else {

                    Toast.makeText(this@LoginActivity, "Incorrect Credential!", Toast.LENGTH_SHORT).show()
                }
            }


        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savepreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}














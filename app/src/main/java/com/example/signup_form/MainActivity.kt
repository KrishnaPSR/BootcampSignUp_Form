package com.example.signup_form

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var username: EditText? = null
    private var password: EditText? = null
    private var phonenumber: EditText? = null
    private var emailid: EditText? = null
    private var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val username = findViewById(R.id.username) as EditText
        val password = findViewById(R.id.password) as EditText
        val emailid = findViewById(R.id.emailid) as EditText
        val phonenumber = findViewById(R.id.phonenumber) as EditText
        val button = findViewById(R.id.button) as Button
        button.setOnClickListener(View.OnClickListener {
            val username1 = username.getText().toString()
            val password1 = password.getText().toString()
            val emailid1 = emailid.getText().toString()
            val phonenumber1 = phonenumber.getText().toString()
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("keyname", username1)
            intent.putExtra("keypassword", password1)
            intent.putExtra("keyemailid", emailid1)
            intent.putExtra("keyphonenumber", phonenumber1)
            startActivity(intent)
        })
    }
}
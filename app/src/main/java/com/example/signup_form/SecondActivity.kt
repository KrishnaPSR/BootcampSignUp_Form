package com.example.signup_form

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class SecondActivity : AppCompatActivity() {
    private val CAMERA_PERMISSION_CODE = 111
    private var username: TextView? = null
    private var password: TextView? = null
    private var emailid: TextView? = null
    private var phonenumber: TextView? = null
    private var camera: Button? = null
    var browser: EditText? = null
    var button1: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val username = findViewById(R.id.text_name) as TextView
        val password = findViewById(R.id.text_password) as TextView
        val emailid = findViewById(R.id.text_emailid) as TextView
        val phonenumber = findViewById(R.id.text_phonenumber) as TextView
        val camera = findViewById(R.id.camera) as Button
        val browser = findViewById(R.id.browser) as EditText
        val button1 = findViewById(R.id.button1) as Button
        val username1 = intent.getStringExtra("keyname")
        val password1 = intent.getStringExtra("keypassword")
        val emailid1 = intent.getStringExtra("keyemailid")
        val phonenumber1 = intent.getStringExtra("keyphonenumber")
        username.setText("Your username is $username1")
        password.setText("Password is $password1")
        emailid.setText("Email ID is $emailid1")
        phonenumber.setText("PhoneNumber is $phonenumber1")
        button1.setOnClickListener(View.OnClickListener {
            val url = browser.getText().toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        })
        camera.setOnClickListener(View.OnClickListener {
            checkPermission(
                Manifest.permission.CAMERA,
                CAMERA_PERMISSION_CODE
            )
        })
    }

    fun checkPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(this@SecondActivity, permission)
            == PackageManager.PERMISSION_DENIED
        ) {
            ActivityCompat.requestPermissions(this@SecondActivity, arrayOf(permission), requestCode)
        } else {
            Toast.makeText(this@SecondActivity, "Permission already granted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 111) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@SecondActivity, "Camera Permission Granted", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this@SecondActivity, "Camera Permission Denied", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    companion object {
        private const val CAMERA_PERMISSION_CODE = 111
    }
}
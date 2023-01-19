package com.example.project

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.project.models.User
import com.example.project.services.AuthService
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection

class login : AppCompatActivity()
{
    private lateinit var authService: AuthService

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        authService = AuthService()

        val txtusername = findViewById<EditText>(R.id.txtusername)
        val txtpassword = findViewById<EditText>(R.id.txtpassword)

        findViewById<Button>(R.id.btnlogin).setOnClickListener {

            val username = txtusername.text.toString()
            val password = txtpassword.text.toString()
            val user = User(Username = username, Password = password)

            CoroutineScope(Dispatchers.IO).launch {
                val response = authService.login(user)
                if (response.code == HttpURLConnection.HTTP_OK)
                {
                    val loggedInUser = Gson().fromJson(response.message, User::class.java)
                    withContext(Dispatchers.Main) {
//                        Toast.makeText(this@login, loggedInUser.Id.toString(), Toast.LENGTH_LONG).show()
                        movie()
                    }
                } else if (response.code == HttpURLConnection.HTTP_NOT_FOUND)
                {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@login, "Wrong email or password", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
        findViewById<TextView>(R.id.lblregisterlink).let {
            it.setOnClickListener {
                val intent = Intent(this, register::class.java)
                startActivity(intent)
            }
        }

        findViewById<TextView>(R.id.lblforgetpassword).let {
            it.setOnClickListener {
                val intent = Intent(this, forgotpasswors::class.java)
                startActivity(intent)
            }
        }
    }

private fun movie()
{
    findViewById<Button>(R.id.btnlogin).let {
            it.setOnClickListener{
                val intent = Intent(this, movie_list_view::class.java)
                startActivity(intent)
            }
        }
}

    }

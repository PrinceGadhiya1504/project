package com.example.project

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class login : AppCompatActivity()
{
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.btnlogin).let {
            it.setOnClickListener{
                val intent = Intent(this, movie::class.java)
                startActivity(intent)
            }
        }

        findViewById<TextView>(R.id.lblregisterlink).let{
            it.setOnClickListener{
                val intent = Intent(this, register::class.java)
                startActivity(intent)
            }
        }

        findViewById<TextView>(R.id.lblforgetpassword).let{
            it.setOnClickListener{
                val intent = Intent(this, forgotpasswors::class.java)
                startActivity(intent)
            }
        }

    }
}
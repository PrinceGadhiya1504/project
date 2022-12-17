package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ShowTime : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_time)

        findViewById<Button>(R.id.btn9am).let {
            it.setOnClickListener {
                val intent = Intent(this, Booking::class.java)
                startActivity(intent)
            }
        }
        findViewById<Button>(R.id.btn3am).let {
            it.setOnClickListener {
                val intent = Intent(this, Booking::class.java)
                startActivity(intent)
            }
        }
        findViewById<Button>(R.id.btn12am).let {
            it.setOnClickListener {
                val intent = Intent(this, Booking::class.java)
                startActivity(intent)
            }
        }
        findViewById<Button>(R.id.btn6am).let {
            it.setOnClickListener {
                val intent = Intent(this, Booking::class.java)
                startActivity(intent)
            }
        }


    }
}
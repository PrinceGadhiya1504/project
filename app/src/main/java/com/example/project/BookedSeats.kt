package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BookedSeats : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booked_seats)

        findViewById<Button>(R.id.btnbooknow).let {
            it.setOnClickListener {
                val intent = Intent(this, Booking::class.java)
                startActivity(intent)
            }
        }

    }
}
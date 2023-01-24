package com.example.project

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.harrywhewell.scrolldatepicker.DayScrollDatePicker
import com.harrywhewell.scrolldatepicker.OnDateSelectedListener
import java.util.*

class ShowTime : AppCompatActivity()
{
    private lateinit var dayPicker: DayScrollDatePicker
    private lateinit var selectDate: String

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_time)

        val c = Calendar.getInstance()

        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        dayPicker = findViewById(R.id.day_date_picker)
        dayPicker.setStartDate(day, month+1, year)
        dayPicker.getSelectedDate { date -> selectDate = date.toString()}

        findViewById<Button>(R.id.btn9am).let {
            it.setOnClickListener {
                val intent = Intent(this, BookedSeats::class.java)
                startActivity(intent)
            }
        }
        findViewById<Button>(R.id.btn3am).let {
            it.setOnClickListener {
                val intent = Intent(this, BookedSeats::class.java)
                startActivity(intent)
            }
        }
        findViewById<Button>(R.id.btn12am).let {
            it.setOnClickListener {
                val intent = Intent(this, BookedSeats::class.java)
                startActivity(intent)
            }
        }
        findViewById<Button>(R.id.btn6am).let {
            it.setOnClickListener {
                val intent = Intent(this, BookedSeats::class.java)
                startActivity(intent)
            }
        }


    }
}
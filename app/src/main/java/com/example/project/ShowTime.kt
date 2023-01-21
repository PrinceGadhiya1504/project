package com.example.project

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.harrywhewell.scrolldatepicker.DayScrollDatePicker
import com.harrywhewell.scrolldatepicker.OnDateSelectedListener
import java.util.*

class ShowTime : AppCompatActivity()
{
    private lateinit var mPicker : DayScrollDatePicker

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_time)

//        mPicker = findViewById(R.id.day_date_picker)
//
//        mPicker.getSelectedDate(object : OnDateSelectedListener
//        {
//            override fun onDateSelected(@Nullable date: Date?)
//            {
//                if (date != null)
//                {
//                    // do something with selected date
//                }
//            }
//        })

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
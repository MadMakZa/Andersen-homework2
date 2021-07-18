package com.example.andersenhomework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActivityCounter : AppCompatActivity() {

    private lateinit var counterTV: TextView
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        //widgets
        counterTV = findViewById(R.id.tv_hawk_count)
        //getCountFromMainActivity
        counter = intent.getIntExtra("count", 0)
        counterTV.text = counter.toString()

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counterKey", counter)
            counterTV.text = counter.toString()
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counterKey", counter)
    }
}
package com.example.andersenhomework2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var counter = 0
    private lateinit var buttonAdd: Button
    private lateinit var buttonDel: Button
    private lateinit var imageCrow: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counterKey")
        }
    }

    private fun init(){

        buttonAdd = findViewById(R.id.btn_add)
        buttonDel = findViewById(R.id.btn_del)
        imageCrow = findViewById(R.id.imageView)
        buttonListener()
    }

    private fun buttonListener(){
        buttonAdd.setOnClickListener {
            addCrow()
            Toast.makeText(this, R.string.crow_stage3, Toast.LENGTH_SHORT).show()
        }
        buttonDel.setOnClickListener {
            if(counter > 0) {
                delCrow()
                Toast.makeText(this, R.string.crow_stage1, Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, R.string.crow_stage2, Toast.LENGTH_SHORT).show()
            }
        }
        imageCrow.setOnClickListener {
            val intent = Intent(this@MainActivity, ActivityCounter::class.java)
            intent.putExtra("count", counter)
            startActivity(intent)
        }
    }

    private fun addCrow(){
        counter++
    }

    private fun delCrow(){
        counter--

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counterKey", counter)
    }

}
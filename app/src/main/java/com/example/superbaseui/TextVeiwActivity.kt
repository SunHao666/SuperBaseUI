package com.example.superbaseui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TextVeiwActivity: AppCompatActivity() {
    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textview)
        context = this
        var setItemView = findViewById<CustomSetItemView>(R.id.setItemView)
        setItemView.setLeftTV("left11231")
            .setRightTV("right123")
            .setOnClickListener(object : SetItemListener{
                override fun onClick() {
                    Toast.makeText(context,"回调了",Toast.LENGTH_SHORT).show()
                }

            })
    }

    fun clickText(view: View){
        println("click")
    }
}
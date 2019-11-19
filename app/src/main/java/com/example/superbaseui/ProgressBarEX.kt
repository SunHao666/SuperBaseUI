package com.example.superbaseui

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class ProgressBarEX : AppCompatActivity() {

    lateinit var pb: ProgressBar
    var pro = 0
    lateinit var cpb : CustomProgressbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pro)
        cpb = findViewById<CustomProgressbar>(R.id.cpb)

        pb = findViewById(R.id.pb)
        var seekbar = findViewById<SeekBar>(R.id.seekbar)
        var tvSeekbar = findViewById<TextView>(R.id.tv_seekbar)

        seekbar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvSeekbar.setText("progress $progress")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
        var time = Timer()
        time.schedule(object : TimerTask() {
            override fun run() {
                var message = Message()

                if (pro < 100) {
                    pro++
                }
                message.obj = pro
                handler.sendMessage(message)
            }
        }, 0,200)

    }

    var handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            pro = msg.obj as Int
            pb.setProgress(pro)
            pb.secondaryProgress = pro + 2

            cpb.setProgressb(pro.toFloat())
        }
    }


}
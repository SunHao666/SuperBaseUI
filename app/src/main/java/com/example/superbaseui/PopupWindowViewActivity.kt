package com.example.superbaseui

import android.os.Build
import android.os.Bundle
import android.text.Layout
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.popu.*

class PopupWindowViewActivity: AppCompatActivity() {
    lateinit var tvLocation : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popu)
        tvLocation = findViewById(R.id.tvlocation)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun showPOPU(view11: View) {
        var view = LayoutInflater.from(this).inflate(R.layout.ppview,null)
        var pop = PopupWindow(view,ViewGroup.LayoutParams.MATCH_PARENT,300)
        pop.isOutsideTouchable = true
        pop.setBackgroundDrawable(getDrawable(R.mipmap.ic_launcher))
        pop.showAsDropDown(view11)
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun showBottom(view1: View) {
        var view = LayoutInflater.from(this).inflate(R.layout.ppview,null)
        var pop = PopupWindow(view,300,300)
        pop.isOutsideTouchable = true
        pop.setBackgroundDrawable(resources.getDrawable(R.mipmap.ic_launcher_round,null))
        pop.showAsDropDown(tvLocation,0,0)
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun showRight(view1: View) {
        var view = LayoutInflater.from(this).inflate(R.layout.ppview,null)
        var pop = PopupWindow(view,300,300)
        pop.isOutsideTouchable = true
        pop.setBackgroundDrawable(resources.getDrawable(R.mipmap.ic_launcher_round,null))
        pop.showAsDropDown(tvlocation,Gravity.CENTER,0,-tvLocation.height)
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun showBottomWindow(view1: View) {
        var view = LayoutInflater.from(this).inflate(R.layout.ppview,null)
        var pop = PopupWindow(view,300,300)
        pop.isOutsideTouchable = true
        pop.setBackgroundDrawable(resources.getDrawable(R.mipmap.ic_launcher_round,null))
        pop.showAtLocation(window.decorView,Gravity.BOTTOM,0,0)
    }
}
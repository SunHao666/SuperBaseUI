package com.example.superbaseui

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow

class CustomPopuwindow: PopupWindow {
    lateinit var mActivity: Activity
    lateinit var mParent: ViewGroup
    lateinit var mContext: Context
    constructor(activity: Activity) {
        mActivity = activity
        initView()
    }

    private fun initView() {
        mParent = mActivity.window.decorView as ViewGroup
        mContext = mParent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_popu, mParent, false)
        //自定义布局
        contentView = view


    }

    fun show(){
        showAtLocation(mParent,Gravity.BOTTOM,0,0)
    }


}
package com.example.superbaseui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.isVisible

/**
 * 组合控件
 * 设置里的item
 */
class CustomSetItemView : RelativeLayout {
    lateinit var mContext: Context
    lateinit var tv_left: TextView
    lateinit var tv_right: TextView
    lateinit var img: ImageView
    var mlistener: SetItemListener? = null
    constructor(context: Context) : super(context) {

    }

    constructor(context: Context,attributeSet: AttributeSet): super(context,attributeSet){

    }

    init {
        LayoutInflater.from(context).inflate(R.layout.setitem, this, true)
        tv_left = findViewById<TextView>(R.id.tv_left)
        tv_right = findViewById<TextView>(R.id.tv_right)
        img = findViewById<ImageView>(R.id.img)

        this.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                if(mlistener != null){
                    mlistener!!.onClick()
                }
            }
        })
    }

    fun setItemListner(listener: SetItemListener){
        mlistener = listener
    }

    fun setLeftTV(mes: String): CustomSetItemView{
        tv_left.isVisible = true
        tv_left.setText(mes)
        return this
    }
    fun setRightTV(mes: String): CustomSetItemView{
        tv_right.isVisible = true
        tv_right.setText(mes)
        return this
    }

    fun setOnClickListener(setItemListener: SetItemListener) {
        mlistener = setItemListener
    }
}

interface SetItemListener{
    fun onClick()
}


package com.example.superbaseui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * 自定义progressbar
 * 测试提交
 */
class CustomProgressbar : View{

    lateinit var mContext: Context
    lateinit var  paint: Paint
    lateinit var  paint1: Paint
    var progress = 0f
    constructor(context: Context): super(context){

    }

    constructor(context: Context,attributeSet: AttributeSet): super(context,attributeSet){
        mContext = context
        initPaint()
    }

    private fun initPaint() {
        paint = Paint()
        paint.color = Color.GRAY
        paint.style = Paint.Style.FILL
        paint.strokeCap = Paint.Cap.ROUND

        paint1 = Paint()
        paint1.color = Color.BLUE
        paint1.style = Paint.Style.FILL
        paint1.strokeCap = Paint.Cap.ROUND
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var rectF = RectF()
        rectF.left = paddingLeft.toFloat()
        rectF.top = paddingTop.toFloat()
        rectF.right = paddingLeft.toFloat()+width
        rectF.bottom = paddingTop.toFloat()+height
        canvas!!.drawRect(rectF,paint)

        var rectF1 = RectF()
        rectF1.left = paddingLeft.toFloat()
        rectF1.top = paddingTop.toFloat()
        rectF1.right = paddingLeft.toFloat()+progress
        rectF1.bottom = paddingTop.toFloat()+height
        canvas!!.drawRect(rectF1,paint1)
    }


    fun setProgressb(pro: Float){
        var part = width/100f
        progress = part*pro
        println("part=$part,pro=$pro,progress$progress")
        invalidate()
    }

}
package com.example.superbaseui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

/**
 * 1.创建
 */
class MSurfaceView : SurfaceView,SurfaceHolder.Callback,Runnable {

    var mHolder: SurfaceHolder? = null
    //子线程标记位，用于标记是否绘制
    var isDrawing = false
    var canvas:Canvas? = null
    var mPaint = Paint()
    var mPath = Path()
    //上次的xy
    var mLastX = 0f
    var mLastY = 0f
    constructor(context: Context): super(context){
    }

    constructor(context: Context,attributeSet: AttributeSet): super(context,attributeSet){
        initSur()
    }

    /**
     * 初始化
     */
    private fun initSur() {
        mHolder = holder
        mHolder!!.addCallback(this)
        isFocusable = true
        isFocusableInTouchMode = true
        keepScreenOn = true

        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.setStrokeWidth(10f)
        mPaint.setColor(Color.parseColor("#FF4081"))
        mPaint.setStyle(Paint.Style.STROKE)
        mPaint.setStrokeJoin(Paint.Join.ROUND)
        mPaint.setStrokeCap(Paint.Cap.ROUND)      //路径

    }

    /**
     * 改变
     */
    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
    }
    /**
     * 销毁
     */
    override fun surfaceDestroyed(holder: SurfaceHolder?) {
    }

    /**
     * 创建
     */
    override fun surfaceCreated(holder: SurfaceHolder?) {

        isDrawing = true
        Thread(this).start()
    }

    override fun run() {
        //不停的绘制
        while (isDrawing){
            drawing()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        var x1 = event!!.x
        var y1 = event!!.y
        when(event.action){
            MotionEvent.ACTION_DOWN ->{
                mLastX = x1
                mLastY = y1

                mPath.moveTo(mLastX,mLastY)
            }
            MotionEvent.ACTION_MOVE ->{
                var dx = Math.abs(x1 - mLastX)
                var dy = Math.abs(y1 - mLastY)

                if(dx > 3 || dy>3){
                    mPath.quadTo(mLastX,mLastY,(mLastX+x)/2,(mLastY+y)/2)
                }
                mLastY = y1
                mLastX = x1
            }
        }

        return true
    }
    private fun drawing() {
        try {
            //拿到画布
            canvas = mHolder!!.lockCanvas()
            //需要绘制的东西。。。
            canvas!!.drawColor(Color.WHITE)
            canvas!!.drawPath(mPath,mPaint)


        }finally {
            if(canvas!= null){
                //确保内容都能够被提交
                mHolder!!.unlockCanvasAndPost(canvas)
            }
        }


    }

}

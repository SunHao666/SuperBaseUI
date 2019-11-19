package com.example.superbaseui

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible

class CustomUpdateDialog : AlertDialog {
    val mContext: Context
    lateinit var tvTitle: TextView
    lateinit var tv_content: TextView
    lateinit var cancle: TextView
    lateinit var sure: TextView
    lateinit var cancleListener: DialogLeftClickListener
    lateinit var sureListener: DialogRightClickListener
    constructor(context: Context) : super(context) {
        mContext = context
        initView()
    }

    //初始化dialog界面
    private fun initView() {
        var view = LayoutInflater.from(mContext).inflate(R.layout.dialog_update, null)
        tvTitle = view.findViewById<TextView>(R.id.tv_title)
        tv_content = view.findViewById<TextView>(R.id.tv_content)
        cancle = view.findViewById<TextView>(R.id.cancle)
        sure = view.findViewById<TextView>(R.id.sure)
        cancle.setOnClickListener { cancleListener.onClick() }
        sure.setOnClickListener { sureListener.onClick() }
        this.setView(view)
        this.setCanceledOnTouchOutside(false)
        var params = this.window!!.attributes
        params.height = 400
    }



    fun setTitle(title: String):CustomUpdateDialog{
        tvTitle.setText(title)
        return this
    }

    fun setContent(content: String):CustomUpdateDialog{
        tv_content.setText(content)
        return this
    }

    fun setCancleClickListener(cancle: DialogLeftClickListener): CustomUpdateDialog{
        cancleListener = cancle
        return this
    }

    fun setSureClickListener(sure: DialogRightClickListener):CustomUpdateDialog {
        sureListener = sure
        return this
    }

    fun setMustUpdate(must: Boolean) : CustomUpdateDialog{
        cancle.isVisible = !must
        return this
    }


}

interface DialogLeftClickListener{
    fun onClick()
}

interface DialogRightClickListener{
    fun onClick()
}
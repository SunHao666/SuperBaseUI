package com.example.superbaseui

import android.app.AlertDialog
import android.app.Dialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DialogActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
    }

    fun dafultDialog(view: View) {
        var dialog = AlertDialog.Builder(this).setTitle("提示")
            .setMessage("来自玛丽的一条信息")
            .setNegativeButton("取消",object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    dialog!!.dismiss()
                }
            })
            .setPositiveButton("确定",object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    dialog!!.dismiss()
                }
            })
        dialog.show()
    }
    fun threeBtnDialog(view: View) {
        var dialog = AlertDialog.Builder(this).setTitle("提示")
            .setMessage("来自玛丽的一条信息")
            .setNegativeButton("取消",object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    dialog!!.dismiss()
                }
            })
            .setPositiveButton("确定",object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    dialog!!.dismiss()
                }
            })
            .setNeutralButton("不确定",object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    dialog!!.dismiss()
                }
            })
        dialog.show()

    }
    fun listDialog(view: View) {
        var strings = arrayOf("1","2","3","4","5")
        var dialog = AlertDialog.Builder(this).setTitle("列表")
            .setItems(strings,object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@DialogActivity,"您点击了${strings[which]}",Toast.LENGTH_SHORT).show()
                }
            })
        dialog.show()
    }
    fun checkboxDialog(view: View) {}
    fun singleDialog(view: View) {}
    fun loadingDialog(view: View) {}
    fun progressDialog(view: View) {
        var proDialog = ProgressDialog(this)
        proDialog.setIcon(R.mipmap.ic_launcher)
        proDialog.setTitle("加载")
        proDialog.setMessage("加载中...")
        proDialog.isIndeterminate = true
        proDialog.setCancelable(true)
        proDialog.show()

    }
    fun inputDialog(view: View) {
        var editText = EditText(this)
        var dialog = AlertDialog.Builder(this)
            .setTitle("输入")
            .setView(editText)
            .setPositiveButton("SURE",object: DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@DialogActivity,"输入的内容是${editText.text.toString()}",Toast.LENGTH_SHORT).show()
                }
            })
        dialog.show()
    }
    fun customDialog(view: View) {}
}
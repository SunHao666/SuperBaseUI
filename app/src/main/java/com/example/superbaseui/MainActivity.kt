package com.example.superbaseui

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun intentTextVeiwActivity(view: View) {
        startActivity(Intent(this,TextVeiwActivity::class.java))
    }

    fun intentDialogActivity(view: View) {
        var dialog = CustomUpdateDialog(this).setTitle("Title")
            .setContent("升级\n sfsdf")
            .setMustUpdate(true)
            .setSureClickListener(object : DialogRightClickListener{
                override fun onClick() {
                    Toast.makeText(this@MainActivity,"收到了",Toast.LENGTH_SHORT).show()
                }
            }).show()

    }

    fun testDialog(view: View) {

        var dialog = AlertDialog.Builder(this).setTitle("title")
            .setMessage("message")
            .setNegativeButton("cancle", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        dialog.show()
    }

    fun progressbar(view: View) {
        startActivity(Intent(this,ProgressBarEX::class.java))
    }

    fun surview(view: View) {
        startActivity(Intent(this,SurfaceViewActivity::class.java))
    }

    fun popupWindowEX(view: View) {
        startActivity(Intent(this,PopupWindowViewActivity::class.java))
    }

    fun dialogEX(view: View) {
        startActivity(Intent(this,DialogActivity::class.java))
    }


    fun toolBarEX(view: View) {
        startActivity(Intent(this,ToolBarActivity::class.java))
    }
}

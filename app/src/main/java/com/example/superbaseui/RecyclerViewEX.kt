package com.example.superbaseui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycle.*
import kotlinx.android.synthetic.main.adapter_recycle.view.*

class RecyclerViewEX : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)
        recycleview.layoutManager = LinearLayoutManager(this)
        var data: MutableList<String> = ArrayList()
        for (i in 0..50){
            data.add("index$i")
        }
        recycleview.adapter = MDapter(this,data)
    }
}

class MDapter(context: Context, data: MutableList<String>) :
    RecyclerView.Adapter<MDapter.ViewHolder>() {
    var mContext = context
    var mData = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.adapter_recycle, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvrec.setText(mData.get(position))
//        11
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvrec = view.tvRec
    }



}

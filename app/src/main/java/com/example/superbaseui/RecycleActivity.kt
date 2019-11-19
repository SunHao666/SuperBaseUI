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

class RecycleActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)
        recycleview.layoutManager = LinearLayoutManager(this)
        var data : MutableList<String> = ArrayList()
        for (i in 0..50){
            data.add("item$i")
        }
        recycleview.adapter = MRecycleAdapter(this,data)
    }

    class MRecycleAdapter : RecyclerView.Adapter<MRecycleAdapter.ViewHolder> {
        lateinit var mContext: Context
        lateinit var mData : MutableList<String>

        constructor(context: Context,data : MutableList<String>){
                mContext = context
                mData = data
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            var view = LayoutInflater.from(mContext).inflate(R.layout.adapter_recycle,null)
            var viewHolder = ViewHolder(view)
            return viewHolder
        }

        override fun getItemCount(): Int {
            return mData.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.tvRecy.setText(mData.get(position))
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var tvRecy = itemView.tvRec
        }

    }
}
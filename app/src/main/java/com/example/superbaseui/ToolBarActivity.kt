package com.example.superbaseui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_toolbar.*

class ToolBarActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_toolbar)

        toolbar1.setTitle("主标题")
        title = "主标题"
        for (i in 0..10){
            tablayout.addTab(tablayout.newTab().setText("TAB$i").setIcon(R.mipmap.ic_launcher))
        }
        tablayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                println("${p0!!.text}")
            }

        })

        tablayout.setupWithViewPager(viewpager)
        var list: MutableList<Fragment> = ArrayList()
        for (i in 0..10){
            list.add(MFragment("page$i"))
        }
        viewpager.adapter = MAdapter(supportFragmentManager,list)


    }

    class MAdapter: FragmentPagerAdapter {

        lateinit var mList : MutableList<Fragment>
        lateinit var mTilte: MutableList<String>
        constructor(fm: FragmentManager,list: MutableList<Fragment>): super(fm){
            mList = list
            mTilte  = ArrayList()
            for (i in 0..10){
                mTilte.add("tab$i")
            }
        }

        override fun getItem(position: Int): Fragment {
            return mList.get(position)
        }

        override fun getCount(): Int {
           return mList.size
        }

        override fun getPageTitle(position: Int): CharSequence? {

            return mTilte.get(position)
        }
    }

    class MFragment : Fragment{
        var mContent = ""
        constructor(content: String){
            mContent = content
        }
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            var textView = TextView(activity)
            textView.text = mContent
            return textView
        }
    }
}
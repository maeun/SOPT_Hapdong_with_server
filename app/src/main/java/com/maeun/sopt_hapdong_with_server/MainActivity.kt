package com.maeun.sopt_hapdong_with_server

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.actionbar_layout.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.framelayout_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actionbar_title.setText("메인")

        addFragment(MainTab())

        //여기에 리스너 달고 this 찍으면 NullPointException 뜸
        //그래서 해당 버튼들을 관장하는 클래스에서 리스너랑 클릭 이벤트 구현해줘야 함
        //korean_btn.setOnClickListener(this)
        //chicken_btn.setOnClickListener(this)
        //pizza_btn.setOnClickListener(this)
        //night_btn.setOnClickListener(this)


        main_home_btn.setOnClickListener {
            replaceFragment(MainTab())
            actionbar_title.setText("메인")

        }

        main_bookmark_btn.setOnClickListener {
            //framelayout_bookmark으로 바꿔주기
            replaceFragment(BookmarkTab())
            actionbar_title.setText("북마크")

        }
    }

    fun addFragment(fragment: android.support.v4.app.Fragment) {
        //FragmentManager는 액티비티만 가질 수 있음, 따라서 MainTab과 같은 Fragment에서는 작동 불가
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.main_frame, fragment)
        transaction.commit()
    }

    fun replaceFragment(fragment: Fragment) {
        //FragmentManager는 액티비티만 가질 수 있음, 따라서 MainTab과 같은 Fragment에서는 activity!!.supportFragmentManager 이렇게 호출해줘야 함
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.main_frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
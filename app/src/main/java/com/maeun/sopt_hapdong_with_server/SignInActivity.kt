package com.maeun.sopt_hapdong_with_server

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.actionbar_layout.*
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        actionbar_title.setText("회원가입")

        signin_signin_btn.setOnClickListener{
            //if로 id 중복 값 및 pw null 처리 해줘야 함
            //Toast.makeText(applicationContext, "중복된 아이디입니다", Toast.LENGTH_SHORT).show()
            //Toast.makeText(applicationContext, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()

            //id 및 pw 조건 통과시 저장 후 액티비티 종료
            Toast.makeText(applicationContext, "회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}

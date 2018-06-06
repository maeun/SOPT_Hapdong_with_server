package com.maeun.sopt_hapdong_with_server

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.actionbar_layout.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        actionbar_title.setText("로그인")

        login_login_btn.setOnClickListener{
            //id 및 pw에 대한 일치 처리 해줘야 함
            //Toast.makeText(applicationContext, "아이디 또는 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            Toast.makeText(applicationContext, "로그인 되었습니다", Toast.LENGTH_SHORT).show()
            val LoginActivity_Intent = Intent(this, MainActivity::class.java)
            startActivity(LoginActivity_Intent)
            finish()
        }

        login_signin_btn.setOnClickListener {
            val SignInActivity_Intent = Intent(this, SignInActivity::class.java)
            startActivity(SignInActivity_Intent)
        }
    }
}

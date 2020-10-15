package com.venuki.venuki

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class IntroActivity : AppCompatActivity() {
    val SPLASH_VIEW_TIME : Long = 2000 // 2초간 유지

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({
         startActivity(Intent(this,MainActivity::class.java))
            finish()
        }, SPLASH_VIEW_TIME)
    }
}
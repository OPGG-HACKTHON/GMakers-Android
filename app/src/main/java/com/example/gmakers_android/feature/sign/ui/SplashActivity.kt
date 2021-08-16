package com.example.gmakers_android.feature.sign.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.gmakers_android.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val dashboardIntent = Intent(this,LoginActivity::class.java)
            startActivity(dashboardIntent)
        },2000)
    }

}
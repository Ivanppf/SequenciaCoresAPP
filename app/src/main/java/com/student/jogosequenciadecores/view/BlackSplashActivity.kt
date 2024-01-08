package com.student.jogosequenciadecores.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.student.jogosequenciadecores.R
import com.student.jogosequenciadecores.databinding.ActivityBlackSplashBinding

class BlackSplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlackSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlackSplashBinding.inflate(layoutInflater)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val nomeClasse = intent.getStringExtra("tela")
            val classe: Class<*> = Class.forName(nomeClasse)
            val i = Intent(this, classe)
            startActivity(i)
            overridePendingTransition(0, R.anim.fadeout)
            finish()
        }, 300)
    }
}
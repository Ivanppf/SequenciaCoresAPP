package com.student.jogosequenciadecores.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.student.jogosequenciadecores.R
import com.student.jogosequenciadecores.databinding.LayoutTelaInicialBinding


class MenuInicial : AppCompatActivity() {

    private lateinit var binding: LayoutTelaInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = LayoutTelaInicialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
        binding.iniciar.setOnClickListener {
            iniciarJogo()
        }

    }

    fun iniciarJogo() {
        val i = Intent(this, BlackSplashActivity::class.java)
        i.putExtra("tela", "com.student.jogosequenciadecores.view.TelaJogo")
        startActivity(i)
        finish()
        overridePendingTransition(0, R.anim.fadeout)
    }

}
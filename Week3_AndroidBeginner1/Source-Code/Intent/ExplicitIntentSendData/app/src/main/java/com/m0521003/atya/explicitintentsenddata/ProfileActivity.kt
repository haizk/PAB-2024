package com.m0521003.atya.explicitintentsenddata

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_NIM = "extra_nim"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_BATCH = "extra_batch"
        const val EXTRA_GRADUATED = "extra_graduated"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvProfileData : TextView = findViewById(R.id.tv_profile_data)

        val nim = intent.getStringExtra(EXTRA_NIM)
        val name = intent.getStringExtra(EXTRA_NAME)
        val batch = intent.getIntExtra(EXTRA_BATCH, 0)
        val isGraduated = intent.getBooleanExtra(EXTRA_GRADUATED, false)

        val text = """
            NIM                 : $nim
            Name                : $name
            Batch               : $batch
            Graduate Status     : $isGraduated
        """.trimIndent()

        tvProfileData.text = text
    }
}
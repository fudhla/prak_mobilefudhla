package com.example.orangcantkikapps.Message.tutorial

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.orangcantkikapps.R
import com.example.orangcantkikapps.databinding.ActivityTutorialMessageBinding

// PENTING: Jangan sampai baris import di bawah ini terlewat agar tidak merah!
import com.example.orangcantkikapps.Message.tutorial.Tutorial1Fragment
import com.example.orangcantkikapps.Message.tutorial.Tutorial2Fragment
import com.example.orangcantkikapps.Message.tutorial.Tutorial3Fragment
import com.example.orangcantkikapps.Message.tutorial.TutorialFragmentAdapter

class TutorialMessageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityTutorialMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Setup ViewPager dengan adapter sesuai modul
        val fragmentsList = listOf(
            Tutorial1Fragment(),
            Tutorial2Fragment(),
            Tutorial3Fragment()
        )

        val adapter = TutorialFragmentAdapter(this, fragmentsList)
        binding.tutorialMessageViewPager.adapter = adapter

        // Hubungkan komponen DotsIndicator dengan ViewPager2
        binding.dotIndicator.attachTo(binding.tutorialMessageViewPager)
    }
}
package com.example.arbeid.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.arbeid.R
import com.example.arbeid.databinding.ActivityHomeBinding
import com.example.arbeid.ui.fragments.TestFragment01
import com.example.arbeid.ui.fragments.TestFragment02

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.bottomNavigationBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(TestFragment01())
                R.id.courses -> replaceFragment(TestFragment02())
                else -> replaceFragment(TestFragment02())
            }; true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val frManager = supportFragmentManager
        val frTransaction = frManager.beginTransaction()

        frTransaction.replace(R.id.fragment_container, fragment)
        frTransaction.commit()
    }
}
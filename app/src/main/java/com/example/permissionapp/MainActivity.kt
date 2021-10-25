package com.example.permissionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.permissionapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setupViews()
        setContentView(binding.root)
    }

    private fun setupViews() {

    }

}
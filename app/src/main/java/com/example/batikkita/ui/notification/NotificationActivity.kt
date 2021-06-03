package com.example.batikkita.ui.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.batikkita.R
import com.example.batikkita.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivActionBack.setOnClickListener {
            onBackPressed()
        }

    }
}
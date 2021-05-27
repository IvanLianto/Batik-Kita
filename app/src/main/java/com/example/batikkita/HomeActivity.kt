package com.example.batikkita

import android.bluetooth.le.ScanFilter
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.plusAssign
import androidx.navigation.ui.setupWithNavController
import com.example.batikkita.databinding.ActivityHomeBinding
import com.example.batikkita.navigation.KeepStateNavigator
import com.example.batikkita.ui.cart.CartFragment
import com.example.batikkita.ui.gift.GiftFragment
import com.example.batikkita.ui.home.HomeFragment
import com.example.batikkita.ui.map.MapFragment
import com.example.batikkita.ui.notification.NotificationFragment
import com.example.batikkita.ui.scan.ScanFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController)
    }
}
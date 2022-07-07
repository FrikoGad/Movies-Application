package com.example.moviesapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.moviesapplication.databinding.ActivityMainBinding
import com.example.moviesapplication.utils.MAIN
import com.example.moviesapplication.utils.NetworkStateChangeReceiver
import com.example.moviesapplication.utils.NetworkStateChangeReceiver.Companion.IS_NETWORK_AVAILABLE
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding?= null
    private val binding get() = mBinding!!
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MAIN = this
        navController = Navigation.findNavController(this, R.id.nav_host)
        networkCheck()
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

    private fun networkCheck() {
        val intentFilter = IntentFilter(NetworkStateChangeReceiver.NETWORK_AVAILABLE_ACTION)
        LocalBroadcastManager.getInstance(this).registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val isNetworkAvailable = intent.getBooleanExtra(IS_NETWORK_AVAILABLE, false)
                val networkStatus = if (isNetworkAvailable) "connected" else "disconnected"
                Snackbar.make(
                    binding.root,
                    "Network Status: $networkStatus", Snackbar.LENGTH_LONG
                ).show()
            }
        }, intentFilter)
    }
}
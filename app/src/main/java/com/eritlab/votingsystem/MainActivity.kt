package com.eritlab.votingsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.eritlab.votingsystem.databinding.ActivityMainBinding
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            val web3j = Web3j.build(HttpService("http://192.168.0.108:7545"))
        try {
            val clientVersion = web3j.web3ClientVersion()
                .sendAsync().get()
            if (!clientVersion.hasError()) {
                Toast.makeText(this, "Connected", Toast.LENGTH_LONG).show()
            } else
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            Toast.makeText(this, e.message.toString(), Toast.LENGTH_LONG).show()
            Log.d("Client_Connection",e.message.toString())
        }

    }
}
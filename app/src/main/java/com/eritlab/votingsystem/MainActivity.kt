package com.eritlab.votingsystem

import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eritlab.votingsystem.contract.VotingContract
import com.eritlab.votingsystem.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.tx.RawTransactionManager
import org.web3j.tx.TransactionManager
import java.math.BigInteger




class MainActivity : AppCompatActivity() {
    private lateinit var web3j: Web3j;
    private lateinit var binding: ActivityMainBinding
    private val  PRIVATE_KEY  = "0af907ef79bb3ec3957606190fb3376f62cb9426388338e4f3502a686b8ed658"
    private val GASS_PRICE: BigInteger = BigInteger.valueOf(20000000000);
    private val GASS_LIMIT: BigInteger = BigInteger.valueOf(6721975)

    //deployed address
    private val _liveDataOfDeployedAddress = MutableLiveData<String>()
    private val liveDataOfDeployedAddress: LiveData<String> = _liveDataOfDeployedAddress;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startVoting.setOnClickListener {

        }

        binding.registerCandidate.setOnClickListener {

        }
        binding.giveVoteAndStatus.setOnClickListener {

        }

        connectWithGanache()
        binding.reconnectBtn.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            connectWithGanache()
        }
        //transaction manager
        val transactionManager: TransactionManager =
            RawTransactionManager(web3j, getCredentialFromPrivateKey())

        val sharedPref = this.getSharedPreferences("voting_system", MODE_PRIVATE)
        val deployedSavedStringAddress = getDeployedAddress(sharedPref)
        //deploy contract
        if (deployedSavedStringAddress == null || deployedSavedStringAddress.isNotEmpty()) {
            binding.progressBar.visibility = View.VISIBLE
            deployContract(web3j, transactionManager, getCredentialFromPrivateKey())
        }

        liveDataOfDeployedAddress.observe(this) {
            if (it != null && it.isNotEmpty()) {
                saveDeployedAddress(sharedPref, it)
                binding.progressBar.visibility = View.GONE
            } else {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
            }
        }

    }


    private fun getCredentialFromPrivateKey(): Credentials {
        return Credentials.create(PRIVATE_KEY)
    }

    private fun connectWithGanache() {
        web3j = Web3j.build(HttpService("http://192.168.0.108:8545"))
        try {
            val clientVersion = web3j.web3ClientVersion()
                .sendAsync().get()
            if (!clientVersion.hasError()) {
                Toast.makeText(this, "Connected", Toast.LENGTH_LONG).show()
                binding.connectionStatus.apply {
                    text = "Connected.."
                    this.setTextColor(Color.GREEN)
                }
                binding.progressBar.visibility = View.GONE
            } else {
                Toast.makeText(this, clientVersion.error.message.toString(), Toast.LENGTH_LONG)
                    .show()
                binding.connectionStatus.apply {
                    text = "Not Connected..."
                    this.setTextColor(Color.RED)
                }
                binding.progressBar.visibility = View.GONE
            }
        } catch (e: Exception) {
            Toast.makeText(this, e.message.toString(), Toast.LENGTH_LONG).show()
            binding.connectionStatus.apply {
                text = "Not Connected..."
                this.setTextColor(Color.RED)
            }
            binding.progressBar.visibility = View.GONE
        }
    }

    //Deploy contract
    private fun deployContract(
        web3j: Web3j,
        transactionManager: TransactionManager,
        credentialFromPrivateKey: Credentials
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            _liveDataOfDeployedAddress.postValue(
                VotingContract.deploy(web3j, transactionManager, GASS_PRICE, GASS_LIMIT)
                    .send().contractAddress
            )
        }
    }


    //share preference
    private fun saveDeployedAddress(sharedPreferences: SharedPreferences, deployedAddress: String) {
        val editor = sharedPreferences.edit()
        editor.putString("deployAddress", deployedAddress)
        editor.apply()
    }

    private fun getDeployedAddress(sharedPreferences: SharedPreferences): String? {
        return sharedPreferences.getString("deployAddress", null)
    }
}
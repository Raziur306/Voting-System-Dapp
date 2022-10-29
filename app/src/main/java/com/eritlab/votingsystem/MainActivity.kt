package com.eritlab.votingsystem

import android.app.ActionBar.LayoutParams
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.eritlab.votingsystem.adapter.RecyclerViewInterface
import com.eritlab.votingsystem.adapter.VotingAdapter
import com.eritlab.votingsystem.contract.VotingContract
import com.eritlab.votingsystem.databinding.ActivityMainBinding
import com.eritlab.votingsystem.databinding.RegisterUserBinding
import com.eritlab.votingsystem.databinding.VoteAndDetailsBinding
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.tx.RawTransactionManager
import org.web3j.tx.TransactionManager
import java.math.BigInteger


class MainActivity : AppCompatActivity(), RecyclerViewInterface {
    private lateinit var web3j: Web3j;
    private lateinit var binding: ActivityMainBinding
    private val PRIVATE_KEY = "0fa25925548a5853ae798c31203868b86e110718825ec48d505c08065f7f9826"
    private val GASS_PRICE: BigInteger = BigInteger.valueOf(20000000000);
    private val GASS_LIMIT: BigInteger = BigInteger.valueOf(6721975)
    private lateinit var votingContract: VotingContract
    private lateinit var symbolList: MutableList<Any?>

    //deployed address
    private val _liveDataOfDeployedAddress = MutableLiveData<String>()
    private val liveDataOfDeployedAddress: LiveData<String> = _liveDataOfDeployedAddress;

    //load toastMessage
    private val _liveToastString = MutableLiveData<String>()
    private val liveToastString: LiveData<String> = _liveToastString

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startVoting.setOnClickListener {
            try {
                val message = votingContract.startVote().sendAsync().get().revertReason
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
            }
        }

        binding.registerCandidate.setOnClickListener {
            registerCandidate()
        }
        binding.giveVoteAndStatus.setOnClickListener {
            showVotingDialog()
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
        } else {
            //get votingContract
            votingContract = loadContract(deployedSavedStringAddress, web3j, transactionManager)
        }


        liveDataOfDeployedAddress.observe(this) {
            if (it != null && it.isNotEmpty()) {
                saveDeployedAddress(sharedPref, it)
                binding.progressBar.visibility = View.GONE
                //get votingContract
                votingContract =
                    loadContract(deployedSavedStringAddress!!, web3j, transactionManager)
            } else {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
            }
        }
        //observe toast string
        liveToastString.observe(this) {
            if (it.isNotEmpty() && it != null) {
                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
            }
        }

    }


    private fun registerCandidate() {
        val dialog = AlertDialog.Builder(this)
        val layoutBinding = RegisterUserBinding.inflate(layoutInflater)
        dialog.setView(layoutBinding.root)
        val alertDialog = dialog.create()
        alertDialog.show()
        layoutBinding.registerButton.setOnClickListener {
            if (layoutBinding.nameCandidate.text.isEmpty()) {
                layoutBinding.nameCandidate.error = "Can't be empty."
            } else if (layoutBinding.symbolCandidate.text.isEmpty()) {
                layoutBinding.symbolCandidate.error = "Can't be empty"
            } else {
                try {
                    votingContract.registrationForCandidate(
                        layoutBinding.nameCandidate.text.toString(),
                        layoutBinding.symbolCandidate.text.toString()
                    ).sendAsync()
                    Toast.makeText(this@MainActivity, "Successfully Registered", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()

                }

                alertDialog.dismiss()
            }

        }

    }


    private fun getCredentialFromPrivateKey(): Credentials {
        return Credentials.create(PRIVATE_KEY)
    }

    private fun connectWithGanache() {
        web3j = Web3j.build(HttpService("http://192.168.0.102:7545"))
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


    private fun loadContract(
        contractAddress: String,
        web3j: Web3j,
        transactionManager: TransactionManager
    ): VotingContract {
        return VotingContract.load(
            contractAddress,
            web3j,
            transactionManager,
            GASS_PRICE,
            GASS_LIMIT
        )
    }

    //Deploy contract
    private fun deployContract(
        web3j: Web3j,
        transactionManager: TransactionManager,
        credentialFromPrivateKey: Credentials
    ) {
        try {
            _liveDataOfDeployedAddress.postValue(
                VotingContract.deploy(web3j, transactionManager, GASS_PRICE, GASS_LIMIT)
                    .sendAsync().get().contractAddress
            )
            binding.showErrorMsg.visibility = View.GONE
        } catch (e: Exception) {
            binding.showErrorMsg.text = e.message.toString()
            Toast.makeText(this, e.message.toString(), Toast.LENGTH_LONG).show()
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


    private fun showVotingDialog() {
        val dialog = AlertDialog.Builder(this)
        val layoutBinding = VoteAndDetailsBinding.inflate(layoutInflater)
        dialog.setView(layoutBinding.root)
        try {
            symbolList = votingContract.symbolList.sendAsync().get()
            val adapter = VotingAdapter(symbolList, this)
            layoutBinding.candidateRecycler.layoutManager = LinearLayoutManager(this)
            layoutBinding.candidateRecycler.adapter = adapter
            val alertDialog = dialog.create()
            alertDialog.show()
            alertDialog.window?.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, e.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }


    override fun onItemClick(position: Int) {
        try {
            votingContract.giveVotes(symbolList[position] as String)
            Toast.makeText(this@MainActivity, "Voted Successfully", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, e.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
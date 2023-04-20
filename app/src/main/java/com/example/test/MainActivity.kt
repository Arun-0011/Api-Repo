package com.example.test

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainAdapter: MainAdapter
    private var isOpen: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadUsers()
        showHide()
    }

    private fun loadUsers() {
        lifecycleScope.launchWhenCreated {
            val response = RetrofitClient.api.fetchTokenDetails()
            if (response.isSuccessful && response.body() != null) {
                binding.itemName.text = response.body()!!.tokendetail[0].token
                binding.itemValue.text = response.body()!!.tokendetail[0].tokenPrice

                val layoutManager = LinearLayoutManager(this@MainActivity)
                binding.listRecyclerView.layoutManager = layoutManager
                mainAdapter = MainAdapter(response.body()!!.tokendetail)
                binding.listRecyclerView.adapter = mainAdapter
            } else {
                Toast.makeText(this@MainActivity, "Something went wrong!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun showHide() {
        binding.actionEye.setOnClickListener {
            if (isOpen) {
                binding.itemName.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                binding.itemValue.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                isOpen = false
                binding.actionEye.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.visibility_off
                    )
                )
            } else {
                binding.itemName.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.itemValue.transformationMethod =
                    PasswordTransformationMethod.getInstance()
                isOpen = true
                binding.actionEye.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.eye
                    )
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

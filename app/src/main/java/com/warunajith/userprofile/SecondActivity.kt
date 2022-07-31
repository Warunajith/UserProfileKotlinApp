package com.warunajith.userprofile

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.warunajith.userprofile.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
    }

    fun loadData() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedName = sharedPreferences.getString("nameKey", null)
        val savedEmail = sharedPreferences.getString("emailKey", null)
        val savedPhone = sharedPreferences.getString("phoneKey", null)



        binding.tvSecondName.setText(savedName)
        binding.tvSecondEmail.setText(savedEmail)
        binding.tvSecondPhone.setText(savedPhone)

    }


}
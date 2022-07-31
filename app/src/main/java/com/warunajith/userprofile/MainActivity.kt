package com.warunajith.userprofile

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.warunajith.userprofile.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegister.setOnClickListener { view ->
            saveData()
            this.goToSecondActivity()
        }

        binding.etName.setOnClickListener {
            binding.etName.text = null
        }

        binding.etEmail.setOnClickListener {
            binding.etEmail.text = null
        }

        binding.etPhone.setOnClickListener {
            binding.etPhone.text = null
        }


    }

    fun goToSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    fun saveData() {
        val insertedName = binding.etName.text.toString()
        val insertedEmail = binding.etEmail.text.toString()
        val insertedPhone = binding.etPhone.text.toString()
        val sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("nameKey", insertedName)
            putString("emailKey", insertedEmail)
            putString("phoneKey", insertedPhone)


        }.apply()

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
    }

}
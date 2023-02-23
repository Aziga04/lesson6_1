package com.example.lesson6_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.lesson6_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var registerForActivityAcResult: ActivityResultLauncher<Intent>

    companion object{
        const val editName: String = "edit_text"
        const val editResult: String = "result"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            if(binding.etSendText.text.toString().isEmpty()){
                Toast.makeText(this,getString(R.string.toastText),Toast.LENGTH_SHORT).show()
               }else {
                Intent(this@MainActivity, SecondActivity::class.java).apply {
                    putExtra(editName, binding.etSendText.text.toString())
                    registerForActivityAcResult.launch(this)
                }
            }
        }
        registerForActivityAcResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            binding.etSendText.setText(result.data?.getStringExtra(editResult))
        }
    }
}
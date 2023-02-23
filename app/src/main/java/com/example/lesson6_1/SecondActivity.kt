package com.example.lesson6_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.lesson6_1.Key.KEY_FOR_RESULT
import com.example.lesson6_1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    companion object{
        const val editName: String = "edit_text"
        const val editResult: String = "result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etSendText.setText(intent.getStringExtra(editName))

        binding.btnSend.setOnClickListener {
            setResult(
                RESULT_OK, Intent().putExtra(
                    editResult,
                    binding.etSendText.text.toString()
                )
            )
            finish()
        }
    }


}
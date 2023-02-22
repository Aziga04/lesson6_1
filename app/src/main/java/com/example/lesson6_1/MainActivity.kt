package com.example.lesson6_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast.makeText
import androidx.activity.result.ActivityResultLauncher
import com.bumptech.glide.Glide
import com.example.lesson6_1.Key.KEY_FOR_RESULT
import com.example.lesson6_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var result : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun initCListeners() {
        binding.btnTran.setOnClickListener {
            if (binding.editText.text.isNullOrEmpty()){
                transferData()
            }else{
                makeText(this, getString(R.string.not_empty))
            }
        }
    }

    private fun transferData() {
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        intent.putExtra(KEY_FOR_RESULT, binding.editText.text.toString())
        result.launch(intent)
    }
    private fun setData(){
        binding.editText.setText(intent.getStringExtra(KEY_FOR_RESULT))
    }
}
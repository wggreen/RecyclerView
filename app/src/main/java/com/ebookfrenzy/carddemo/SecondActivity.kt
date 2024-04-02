package com.ebookfrenzy.carddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import com.ebookfrenzy.carddemo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return

        val title = extras.getString("title")
        binding.selectedTitle.text = title

        val detail = extras.getString("detail")
        binding.selectedDetails.text = detail

        val image = extras.getInt("image")
        binding.selectedImageView.setImageResource(image)


    }
}
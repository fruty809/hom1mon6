package com.example.hom1mon6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hom1mon6.databinding.ActivityMainBinding
import com.example.hom1mon6.ext.loadImage
import java.util.*
import kotlin.random.Random.Default.nextInt


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val images = mutableListOf("https://images.freeimages.com/images/previews/7df/2848-x-2136-pixels-9-5-x-7-1-300dpi-2720-kbytes-jpg-1387455.jpg",
        "https://images.freeimages.com/images/previews/d37/mem666-2007-011400241-jpg-1364340.jpg",
        "https://images.freeimages.com/images/previews/509/dscf0538-jpg-1625290.jpg",
        "https://images.freeimages.com/images/previews/b1a/scn-prk-007-jpg-1625285.jpg",
        "https://images.freeimages.com/images/previews/aad/gazebo052607-jpg-1364335.jpg")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        binding.btnSubmit.setOnClickListener {
            val photoUrl = binding.edUrl.text.toString()
            if (photoUrl.isNotBlank()){
                images.add(photoUrl)
                binding.edUrl.text.clear()
            }
        }
        binding.btnRandom.setOnClickListener {
            val randomImage = images[Random.nextInt(images.size)]
            binding.imgPhotos.loadImage(randomImage)
        }
    }
}
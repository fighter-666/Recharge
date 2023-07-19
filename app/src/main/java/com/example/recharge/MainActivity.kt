package com.example.recharge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recharge.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val piggies = listOf(
            Pair(R.drawable.image1, "充流量"),
            Pair(R.drawable.image2, "开通自动充"),
            Pair(R.drawable.image3, "电子发票"),
            Pair(R.drawable.image4, "充值记录"),
            Pair(R.drawable.image4, "充值记录"),
            Pair(R.drawable.image4, "充值记录")
        ).map { (imageResId, helperText) ->
            Piggy(imageResId, helperText)
        }.toMutableList()
        val myAdapter = FirstAdapter(R.layout.first, piggies)
        binding.recyclerView.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false))
        binding.recyclerView.setAdapter(myAdapter)



    }
}


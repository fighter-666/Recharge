package com.example.recharge

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recharge.databinding.ActivityMainBinding
import com.example.recharge.databinding.FirstBinding


class FirstActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val piggies = listOf(
            Pair(R.drawable.arrow_down_float, "QMUIColorHelper3"),
            Pair(R.drawable.arrow_down_float, "QMUIDeviceHelper"),
            Pair(R.drawable.arrow_down_float, "QWUIDrawableHelper"),
            Pair(R.drawable.arrow_down_float, "QMUIStatusBarHelper"),
            Pair(R.drawable.arrow_down_float, "QMUIViewHelper"),
            Pair(R.drawable.arrow_down_float, "QMUINotchHelper")
        ).map { (imageResId, helperText) ->
            Piggy(imageResId, helperText)
        }.toMutableList()
        val myAdapter = FirstAdapter(R.layout.first, piggies)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = myAdapter
        }
    }
}


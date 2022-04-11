package com.ariadnext.client.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ariadnext.client.databinding.ActivityMainBinding

/**
 * The main activity.
 * */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).apply {

            setContentView(root)
        }
    }

}

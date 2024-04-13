package com.example.android_homework_1

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.isVisible
import com.example.android_homework_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val counter = Counter(49)
        setContentView(binding.root)
        val seatsView = SeatsView()
        binding.counter.text = counter.printCount()
        binding.availableSeats.text = getText(R.string.availableSeats)
        binding.buttonReset.isEnabled = false
        binding.buttonReset.isVisible = false

        fun viewStatus (num: Int) {
            if (num == 0) {
                binding.availableSeats.setTextColor(Color.GREEN)
                binding.buttonMinus.isEnabled = false
                binding.buttonPlus.isEnabled = true
                binding.buttonReset.isEnabled = false
                binding.buttonReset.isVisible = false
            }
            if (num == 1) {
                binding.availableSeats.setTextColor(Color.BLUE)
                binding.buttonMinus.isEnabled = true
                binding.buttonPlus.isEnabled = true
                binding.buttonReset.isEnabled = false
                binding.buttonReset.isVisible = false
            }
            if (num == 2) {
                binding.availableSeats.setTextColor(Color.RED)
                binding.buttonPlus.isEnabled = false
                binding.buttonMinus.isEnabled = true
                binding.buttonReset.isEnabled = true
                binding.buttonReset.isVisible = true
            }
        }

        binding.buttonPlus.setOnClickListener {
            viewStatus(counter.status())
            counter.counterPlus()
            binding.counter.text = counter.printCount()
            binding.availableSeats.text = seatsView.seatsView(counter.count, counter.countMax)
        }

        binding.buttonMinus.setOnClickListener {
            viewStatus(counter.status())
            counter.counterMinus()
            viewStatus(counter.status())
            binding.counter.text = counter.printCount()
            binding.availableSeats.text = seatsView.seatsView(counter.count, counter.countMax)
        }

        binding.buttonReset.setOnClickListener {
            counter.count = 0
            binding.counter.text = counter.printCount()
            binding.availableSeats.text = seatsView.seatsView(counter.count, counter.countMax)
            viewStatus(counter.status())
        }

    }
}
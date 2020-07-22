package com.nichotined.weather.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nichotined.weather.R
import com.nichotined.weather.utils.InjectorUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factory = InjectorUtil.provideMainViewModelFactory()
        viewModel = ViewModelProvider(this, factory).get(MainActivityViewModel::class.java)
        viewModel.weather.observe(this, Observer { t ->
            temperatureTxt.text = t.temperature
        })
        setButtonListener()
    }

    private fun setButtonListener() {
        toCelciusBtn.setOnClickListener {
            viewModel.onToCelsiusClicked()
            temperatureTxt.text = viewModel.weather.value?.temperature
        }

        toFahrenheitBtn.setOnClickListener {
            viewModel.onToFahrenheit()
            temperatureTxt.text = viewModel.weather.value?.temperature
        }
    }
}
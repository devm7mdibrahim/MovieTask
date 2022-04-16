package com.devm7mdibrahim.presentation.ui

import android.os.Bundle
import com.devm7mdibrahim.presentation.R
import com.devm7mdibrahim.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
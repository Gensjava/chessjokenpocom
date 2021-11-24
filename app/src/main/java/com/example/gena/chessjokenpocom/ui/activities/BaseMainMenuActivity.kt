package com.example.gena.chessjokenpocom.ui.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.example.gena.chessjokenpocom.R

class BaseMainMenuActivity: BaseActionBarActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
       // activityMainBinding.setPresenter(homeFragmentPresenter)
        initViews()
    }
}
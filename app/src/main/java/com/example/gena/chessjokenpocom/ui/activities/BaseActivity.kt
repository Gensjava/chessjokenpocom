package com.example.gena.chessjokenpocom.ui.activities

import android.annotation.SuppressLint
import com.arellomobile.mvp.MvpAppCompatActivity

@SuppressLint("Registered")
abstract class BaseActivity : MvpAppCompatActivity() {

    abstract fun initViews()

}
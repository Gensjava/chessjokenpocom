package com.example.gena.chessjokenpocom.ui.activities

import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.MenuItem

@SuppressLint("Registered")
open class BaseActionBarActivity : BaseActivityView() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHomeButton()
    }

    protected fun setHomeButton(title: String) {
        val actionBar: ActionBar = this.supportActionBar!!
        actionBar.setHomeButtonEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.title = title
    }

    protected fun setHomeButton() {
        val actionBar: ActionBar = this.supportActionBar!!
        actionBar.setHomeButtonEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    protected fun setHomeNoArrowButton() {
        val actionBar: ActionBar = this.supportActionBar!!
        actionBar.setHomeButtonEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(false)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home -> {
                super.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
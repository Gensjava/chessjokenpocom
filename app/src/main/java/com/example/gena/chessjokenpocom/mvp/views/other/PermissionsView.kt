package com.example.gena.chessjokenpocom.mvp.views.other

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(OneExecutionStateStrategy::class)
interface PermissionsView : MvpView {
    fun showPermissionsNotGranted()

    fun showPermissions()

    fun requestPermissions()

    fun successPermissions()

    fun showError(error: String)

    fun onRequestPermissionsResultDefault(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    )

    fun onRequestPermissions()

}
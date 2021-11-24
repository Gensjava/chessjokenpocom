package com.example.gena.chessjokenpocom.helpers

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment

import android.util.Log
import com.example.gena.chessjokenpocom.R
import com.example.gena.chessjokenpocom.ui.activities.BaseActivity
import com.example.gena.chessjokenpocom.ui.fragments.dialogs.SorryDialogOkFragment

object WindowHelper {

    fun showFragment(fragmentClass: Class<*>, baseActivity: BaseActivity) {
        val fragment = getFragment(fragmentClass)
        commitFragment(fragmentClass, baseActivity, fragment, R.id.content)
    }

    fun showFragment(fragmentClass: Class<*>, bundleItem: Bundle, baseActivity: BaseActivity) {
        val fragment = getFragment(fragmentClass)
        if (fragment != null) {
            fragment.arguments = bundleItem
        }
        commitFragment(fragmentClass, baseActivity, fragment, R.id.content)
    }

    fun showFragment(
        fragmentClass: Class<*>,
        baseActivity: BaseActivity,
        content: Int,
        bundleItem: Bundle
    ) {
        val fragment = getFragment(fragmentClass)
        if (fragment != null) {
            fragment.arguments = bundleItem
        }
        commitFragment(fragmentClass, baseActivity, fragment, content)
    }

    fun showFragment(fragmentClass: Class<*>, baseActivity: BaseActivity, content: Int) {
        val fragment = getFragment(fragmentClass)
        commitFragment(fragmentClass, baseActivity, fragment, content)
    }

    private fun commitFragment(
        fragmentClass: Class<*>,
        baseActivity: BaseActivity,
        fragment: Fragment?,
        content: Int
    ) {
        if (fragment != null) {
            val fragmentManager = baseActivity.supportFragmentManager
            val ft = fragmentManager.beginTransaction()
            fragmentManager.popBackStack(fragment.javaClass.simpleName, 0)
            ft.addToBackStack(fragment.javaClass.simpleName)
            ft.replace(content, fragment, fragment.javaClass.simpleName)
            ft.commit()
        } else {
            Log.e(
                fragmentClass.toString(),
                baseActivity.getString(R.string.error_fragment_is_not_created)
            )
        }
    }

    fun getLinkFragment(fragmentClass: Class<*>, baseActivity: BaseActivity): Fragment? {
        var fragment: Fragment?
        fragment = baseActivity.supportFragmentManager.findFragmentByTag(fragmentClass.simpleName)
        if (fragment == null) {
            try {
                fragment = getFragment(fragmentClass)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        return fragment
    }

    fun showDialogFragment(
        fragmentClass: Class<*>,
        error: String,
        sa: String,
        baseActivity: BaseActivity
    ): DialogFragment? {
        val dialogFragment = getDialogFragment(fragmentClass)
        val manager = baseActivity.supportFragmentManager
        val transaction = manager.beginTransaction()
        dialogFragment?.show(transaction, fragmentClass.simpleName)
        return dialogFragment
    }

    fun showDialogFragment(fragmentClass: Class<*>, baseActivity: BaseActivity): DialogFragment? {
        val dialogFragment = getDialogFragment(fragmentClass)
        val manager = baseActivity.supportFragmentManager
        val transaction = manager.beginTransaction()
        dialogFragment?.show(transaction, fragmentClass.simpleName)
        return dialogFragment
    }


    fun showDialogFragment(
        fragmentClass: Class<*>,
        bundleItem: Bundle,
        baseActivity: BaseActivity
    ): DialogFragment? {
        val dialogFragment = getDialogFragment(fragmentClass)
        val manager = baseActivity.supportFragmentManager
        val transaction = manager.beginTransaction()
        if (dialogFragment != null) {
            dialogFragment.arguments = bundleItem
            dialogFragment.show(transaction, fragmentClass.simpleName)
        }
        return dialogFragment
    }

    fun showDialogFragment(fragmentClass: Class<*>, massage: String, baseActivity: BaseActivity) {
        val bundle = Bundle()
        bundle.putString(SorryDialogOkFragment.MASSAGE, massage)
        showDialogFragment(fragmentClass, bundle, baseActivity)
    }

    fun showDialogFragment(
        fragmentClass: Class<*>,
        massage: String,
        code: Int,
        baseActivity: BaseActivity
    ) {
        val bundle = Bundle()
        bundle.putString(SorryDialogOkFragment.MASSAGE, massage)
        bundle.putInt(SorryDialogOkFragment.CODE_MISTAKE, code)
        showDialogFragment(fragmentClass, bundle, baseActivity)
    }

    @SuppressLint("RestrictedApi")
    fun hideDialogFragment(fragmentClass: Class<*>, baseActivity: BaseActivity) {
        for (dialogFragment in baseActivity.supportFragmentManager.fragments) {
            if (dialogFragment == null) {
                continue
            }
            if (dialogFragment.tag == fragmentClass.simpleName) {
                try {
                    (dialogFragment as DialogFragment).dismiss()
                } catch (e: Exception) {
                    e.stackTrace
                }

            }
        }
    }

    fun showWebPage(baseActivity: BaseActivity, linkWebSite: String) {
        val address = Uri.parse(linkWebSite)
        val openLinkIntent = Intent(Intent.ACTION_VIEW, address)
        baseActivity.startActivity(openLinkIntent)
    }

    fun showMakeCall(baseActivity: BaseActivity, phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse(String.format("tel:%s", phoneNumber))
        baseActivity.startActivity(intent)
    }

    fun showActivity(aClass: Class<*>, baseActivity: BaseActivity) {
        val intent = Intent(baseActivity, aClass)
        baseActivity.startActivity(intent)
        baseActivity.finish()
    }

    private fun getFragment(fragmentClass: Class<*>): Fragment? {
        var fragment: Fragment? = null
        try {
            fragment = fragmentClass.newInstance() as Fragment
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return fragment
    }

    private fun getDialogFragment(fragmentClass: Class<*>): DialogFragment? {
        var dialogFragment: DialogFragment? = null
        try {
            dialogFragment = fragmentClass.newInstance() as DialogFragment
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

        return dialogFragment
    }

    fun getCurrentFragment(baseActivity: BaseActivity): Fragment? {
        return baseActivity.supportFragmentManager
            .findFragmentById(R.id.content)
    }
}
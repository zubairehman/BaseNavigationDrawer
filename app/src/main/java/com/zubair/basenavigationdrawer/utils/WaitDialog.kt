package com.zubair.basenavigationdrawer.utils

import android.app.Dialog
import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.Window
import com.zubair.basenavigationdrawer.R
import com.zubair.basenavigationdrawer.databinding.WaitDialogBinding

class WaitDialog(private val context: Context) {
    private var dialog: Dialog? = null
    var isStillActive: Boolean = false
        private set

    fun showWaitDialog() {
        isStillActive = true
        val binding: WaitDialogBinding
        if (dialog != null) dialog!!.dismiss()
        dialog = Dialog(context)
        dialog!!.setCancelable(false)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.wait_dialog, null, false)
        dialog!!.setContentView(binding.root)
        dialog!!.setOnCancelListener { isStillActive = false }
        dialog!!.show()
    }

    fun dismissWaitDialog() {
        if (dialog != null && dialog!!.isShowing) {
            dialog!!.cancel()
        }
    }

}

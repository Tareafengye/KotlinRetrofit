package com.tiantian.kotlindemo.util

import android.app.Dialog
import android.content.Context
import com.tiantian.kotlindemo.R
import kotlinx.android.synthetic.main.dialog_loading_layout.view.*

/**
 *    author : Mr.liu
 *    e-mail : Tareafengye@163.com
 *    Github: https://github.com/Tareafengye
 *    date   : 2018/12/10/0010下午 14:44
 *    desc   :
 *   version: 1.0
 */
object LoadingDialog {
    private var dialog:Dialog?=null
    fun show(context: Context){
        cancel()
        dialog= Dialog(context, R.style.LoadingDialogAnimStyle)
        dialog?.setContentView(R.layout.dialog_loading_layout)
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.show()
    }
    fun cancel(){
        dialog?.dismiss()
    }
}
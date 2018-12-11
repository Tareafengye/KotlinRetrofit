package com.tiantian.kotlindemo.listtner

import android.view.View

/**
 * author : Mr.liu
 * e-mail : Tareafengye@163.com
 * Github: https://github.com/Tareafengye
 * date   : 2018/12/10/0010下午 16:52
 * desc   :
 * version: 1.0
 */
interface ItemClickListtenner {
    fun onItemClick(view: View, position: Int)

    fun onItemLongClick(view: View, position: Int): Boolean
}

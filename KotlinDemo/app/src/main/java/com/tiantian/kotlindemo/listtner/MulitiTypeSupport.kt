package com.tiantian.kotlindemo.listtner

/**
 * author : Mr.liu
 * e-mail : Tareafengye@163.com
 * Github: https://github.com/Tareafengye
 * date   : 2018/12/10/0010下午 16:53
 * desc   :
 * version: 1.0
 */
interface MulitiTypeSupport<T> {
    fun getLayoutId(item: T): Int
}

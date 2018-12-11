package com.tiantian.kotlindemo.api

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *    author : Mr.liu
 *    e-mail : Tareafengye@163.com
 *    Github: https://github.com/Tareafengye
 *    date   : 2018/12/10/0010下午 15:18
 *    desc   :转换器
 *   version: 1.0
 */
object NetworkScheduler{
    fun <T> compose():ObservableTransformer<T,T>{
        return ObservableTransformer { observable->observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }
    }
}
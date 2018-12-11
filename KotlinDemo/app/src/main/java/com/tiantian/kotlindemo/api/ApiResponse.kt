package com.tiantian.kotlindemo.api

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.tiantian.kotlindemo.util.LoadingDialog
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException

/**
 *    author : Mr.liu
 *    e-mail : Tareafengye@163.com
 *    Github: https://github.com/Tareafengye
 *    date   : 2018/12/10/0010下午 14:38
 *    desc   :观察者，对网络的各种情况进行处理
 *   version: 1.0
 */
abstract class ApiResponse<T>(private val context: Context):Observer<T> {
    abstract fun success(data:T)
    abstract fun failure(error:Int,apiErrorModel: ApiErrorModel)
    override fun onComplete() {
        LoadingDialog.cancel()
    }

    override fun onSubscribe(d: Disposable) {
        LoadingDialog.show(context)
    }

    override fun onNext(t: T) {
        success(t)
        Log.d("onerrorcode","zhxingle")
    }

    override fun onError(e: Throwable) {
        Log.d("onerrorcode",e.message)
        LoadingDialog.cancel()
        if (e is HttpException){
            val apiErrorModel:ApiErrorModel=when(e.code()){
                ApiErrorType.INTERNAL_SERVER_ERROR.code->
                    ApiErrorType.INTERNAL_SERVER_ERROR.getApiErrorModel(context)
                ApiErrorType.BAD_GATEWAY.code->
                    ApiErrorType.BAD_GATEWAY.getApiErrorModel(context)
                ApiErrorType.NOT_FOUND.code ->
                    ApiErrorType.NOT_FOUND.getApiErrorModel(context)
                else-> otherError(e)
            }
            failure(e.code(),apiErrorModel)
        }
    }
    private fun otherError(e: HttpException) =
            Gson().fromJson(e.response().errorBody()?.charStream(), ApiErrorModel::class.java)
}
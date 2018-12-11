package com.tiantian.kotlindemo.api

import com.tiantian.kotlindemo.BuildConfig
import com.tiantian.kotlindemo.api.ApiService.Companion.baseUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 *    author : Mr.liu
 *    e-mail : Tareafengye@163.com
 *    Github: https://github.com/Tareafengye
 *    date   : 2018/12/10/0010下午 13:58
 *    desc   :
 *   version: 1.0
 */
class ApiClient private constructor(){
lateinit var apiService: ApiService
    private object Houlder{
        val INSTANCE=ApiClient()
    }
    companion object {
        val instance by lazy { Houlder.INSTANCE }
    }
    fun init(){
        val okHttpClient=OkHttpClient().newBuilder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(
                        if(BuildConfig.DEBUG)HttpLoggingInterceptor.Level.BODY
                         else  HttpLoggingInterceptor.Level.NONE
                )).build()
        val retrofit=Retrofit.Builder()
                .baseUrl(baseUrl)//域名
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        apiService=retrofit.create(ApiService::class.java)
    }


}
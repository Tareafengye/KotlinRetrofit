package com.tiantian.kotlindemo.api

import com.tiantian.kotlindemo.entity.GankModel
import io.reactivex.Observable
import okhttp3.Call
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *    author : Mr.liu
 *    e-mail : Tareafengye@163.com
 *    Github: https://github.com/Tareafengye
 *    date   : 2018/12/10/0010上午 10:50
 *    desc   :
 *   version: 1.0
 */
interface ApiService {
    companion object {
        //此类接口的基地址
        val baseUrl = "https://gank.io/api/data/"
    }
    @GET("{type}/10/1")
    fun listRepos(@Path("type")string: String): Observable<GankModel>

}
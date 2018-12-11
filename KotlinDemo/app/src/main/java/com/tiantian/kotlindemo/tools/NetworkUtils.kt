package com.tiantian.kotlindemo.tools

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

import com.tiantian.kotlindemo.app.App

/**
 * author : Mr.liu
 * e-mail : Tareafengye@163.com
 * Github: https://github.com/Tareafengye
 * date   : 2018/12/7/0007下午 15:59
 * desc   :
 * version: 1.0
 */
class NetworkUtils {
    companion object {
        /**
         * 判断网络是否连接
         *
         * 需添加权限 `<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>`
         *
         * @return `true`: 是<br></br>`false`: 否
         */
        val isConnected: Boolean
            get() {
                val info = activeNetworkInfo
                return info != null && info.isConnected
            }
        /**
         * 获取活动网络信息
         *
         * 需添加权限 `<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>`
         *
         * @return NetworkInfo
         */
        private val activeNetworkInfo: NetworkInfo?
            @SuppressLint("MissingPermission")
            get() {
                val cm = App.instance!!
                        .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                return cm.activeNetworkInfo
            }

    }

}

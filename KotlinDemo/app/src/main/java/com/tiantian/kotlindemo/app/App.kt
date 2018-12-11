package com.tiantian.kotlindemo.app

import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.WindowManager
import com.tiantian.kotlindemo.api.ApiClient


import java.util.HashMap


/**
 * Created by Administrator on 2018/3/2 0002.
 */

class App : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        ApiClient.instance.init()
    }

    companion object {
        var instance: App? = null
            private set
        private val destoryMap = HashMap<String, Activity>()

        /**
         * 添加到销毁队列
         *
         * @param activity 要销毁的activity
         */
        fun addDestoryActivity(activity: Activity, activityName: String) {
            destoryMap[activityName] = activity
        }

        /**
         * 销毁指定Activity
         */
        fun destoryActivity(activityName: String) {
            val keySet = destoryMap.keys
            if (keySet.size > 0) {
                for (key in keySet) {
                    if (activityName == key) {
                        destoryMap[key]!!.finish()
                    }
                }
            }
        }

        val mywmParams = WindowManager.LayoutParams()
    }

}

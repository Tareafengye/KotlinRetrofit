package com.tiantian.kotlindemo.tools

import android.app.Activity
import android.content.Context
import android.util.Log

import java.util.Stack

/**
 * author : Mr.liu
 * e-mail : Tareafengye@163.com
 * Github: https://github.com/Tareafengye
 * date   : 2018/12/7/0007下午 15:30
 * desc   :Activity管理类
 * version: 1.0
 */
class ActivityManager private constructor() {

    /**
     * 添加Activity到堆栈
     */
    @Synchronized
    fun addActivity(activity: Activity) {
        if (activityStack == null) {
            activityStack = Stack()
        }
        activityStack!!.add(activity)
        Log.i("TAG", "ActivityManager添加了：" + activity.javaClass.name)
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    fun currentActivity(): Activity {
        return activityStack!!.lastElement()
    }

    /**
     * 移除最后一个Activity
     */
    fun removeActivity(activity: Activity?) {
        if (activity != null) {
            activityStack!!.remove(activity)
            Log.i("TAG", "ActivityManager移除了：" + activity.javaClass.name)
        }
    }

    /**
     * 结束指定的Activity
     */
    @JvmOverloads
    fun finishActivity(activity: Activity? = activityStack!!.lastElement()) {
        if (activity != null) {
            activityStack!!.remove(activity)
            activity.finish()
            Log.i("TAG", "ActivityManager关闭了：" + activity.javaClass.name)
        }
    }

    /**
     * 结束指定类名的Activity
     */
    fun finishActivity(cls: Class<*>) {
        for (i in activityStack!!.indices) {
            if (activityStack!![i].javaClass == cls) {
                finishActivity(activityStack!![i])
                removeActivity(activityStack!![i])
                return
            }
        }
    }


    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        for (activity in activityStack!!) {
            activity?.finish()
        }
        activityStack!!.clear()
    }


    /**
     * 退出应用程序
     */
    fun AppExit(context: Context) {
        try {
            finishAllActivity()
            val activityMgr = context.getSystemService(Context.ACTIVITY_SERVICE) as android.app.ActivityManager
            activityMgr.restartPackage(context.packageName)
            System.exit(0)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    companion object {

        private var activityStack: Stack<Activity>? = null
        private var instance: ActivityManager? = null

        /**
         * 单一实例
         */
        val appInstance: ActivityManager
            @Synchronized get() {
                if (instance == null) {
                    instance = ActivityManager()
                }
                return instance as ActivityManager
            }
    }

}
/**
 * 结束当前Activity（堆栈中最后一个压入的）
 */

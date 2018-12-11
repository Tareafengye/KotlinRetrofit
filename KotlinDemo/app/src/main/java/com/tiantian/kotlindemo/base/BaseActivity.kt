package com.tiantian.kotlindemo.base

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentActivity
import butterknife.ButterKnife
import android.content.Intent
import com.tiantian.kotlindemo.tools.ActivityManager
import com.tiantian.kotlindemo.tools.DoubleUtils
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity


abstract class BaseActivity : RxAppCompatActivity(){
    protected var mContext: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ButterKnife.bind(this)
        ActivityManager.appInstance.addActivity(this)//将当前activity添加进入管理栈
        mContext = this
        // 接收传参
        preInitView()
        // 设置布局
        if (0 != getLayoutResId()) {
            setContentView(getLayoutResId())
        }
        // 初始化子View
        initView()
        // 初始化事件监听
        initViewListener()
    }

    abstract fun preInitView()
    abstract fun getLayoutResId(): Int
    abstract fun initView()
    abstract fun initViewListener()

    protected fun startActivity(clz: Class<*>, bundle: Bundle) {
        if (!DoubleUtils.isFastDoubleClick()) {
            val intent = Intent()
            intent.setClass(this, clz)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}
package com.tiantian.kotlindemo.tools

import android.widget.Toast

import com.tiantian.kotlindemo.app.App

/**
 * author : Mr.liu
 * e-mail : Tareafengye@163.com
 * Github: https://github.com/Tareafengye
 * date   : 2018/12/7/0007下午 15:56
 * desc   :
 * version: 1.0
 */
class ByAlert {
    companion object {
        fun alert(info: String?) {
            if (info != null) {
                if (info == "用户ID缺失" || info == "UID不能为空") {
                    Toast.makeText(App.instance, "亲,你还未登录,登录后更精彩",
                            Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(App.instance, info, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}

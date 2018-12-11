package com.tiantian.kotlindemo.holder

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.widget.ImageView
import android.widget.TextView

/**
 * author : Mr.liu
 * e-mail : Tareafengye@163.com
 * Github: https://github.com/Tareafengye
 * date   : 2018/12/10/0010下午 16:54
 * desc   :
 * version: 1.0
 */
class RecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //用于缓存界面
    private val mViews = SparseArray<View>()

    /***
     * 通过viewId获取控件
     * @param viewId
     * @param <T>
     * @return
    </T> */
    fun <T : View> getView(viewId: Int): T? {
        //多次findviewByID，对已有的view进行缓存
        var view: View? = mViews.get(viewId)
        //使用缓存的方法减少findViewByID的次数
        if (view == null) {
            view = itemView.findViewById(viewId)
            mViews.put(viewId, view)
        }
        return view as T?
    }

    /***
     * 对通用功能进行封装
     * @param viewId
     * @param text
     * @return
     */
    fun setText(viewId: Int, text: CharSequence): RecyclerHolder {
        val textView = getView<TextView>(viewId)
        textView?.text = text
        return this
    }

    /***
     * 设置图片资源
     * @param viewId
     * @param resourceId
     * @return
     */
    fun setImageResource(viewId: Int, resourceId: Int): RecyclerHolder {
        val imageView = getView<ImageView>(viewId)
        imageView?.setImageResource(resourceId)
        return this
    }
}

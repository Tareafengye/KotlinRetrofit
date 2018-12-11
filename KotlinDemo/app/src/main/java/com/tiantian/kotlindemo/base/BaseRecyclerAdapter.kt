package com.tiantian.kotlindemo.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.tiantian.kotlindemo.holder.RecyclerHolder
import com.tiantian.kotlindemo.listtner.ItemClickListtenner
import com.tiantian.kotlindemo.listtner.MulitiTypeSupport

/**
 * author : Mr.liu
 * e-mail : Tareafengye@163.com
 * Github: https://github.com/Tareafengye
 * date   : 2018/12/10/0010下午 16:52
 * desc   :
 * version: 1.0
 */
abstract class BaseRecyclerAdapter<T>(context: Context, //通过泛型传递
                                      private val mDatas: List<T>, //条目ID不一样只能通过参数传递
                                      private var mLayoutId: Int) : RecyclerView.Adapter<RecyclerHolder>() {
    //实例化LayoutInflate
    private val mInlater: LayoutInflater = LayoutInflater.from(context)
    //多布局接口
    private var muTypeSuport: MulitiTypeSupport<T>? = null

    /***
     * 设置点击事件
     */
    private var listtenner: ItemClickListtenner? = null

    constructor(context: Context, mDatas: List<T>, typeSuport: MulitiTypeSupport<T>) : this(context, mDatas, -1) {
        this.muTypeSuport = typeSuport
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder {

        if (muTypeSuport != null) {
            //使用多布局
            mLayoutId = viewType
        }
        //创建View
        val itemView = mInlater.inflate(mLayoutId, parent, false)


        return RecyclerHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        //对Viewhouder的优化
        convert(holder, mDatas[position], position)
        //条目点击事件

        if (listtenner != null) {
            holder.itemView.setOnClickListener { view -> listtenner!!.onItemClick(view, position) }
            holder.itemView.setOnLongClickListener { view -> listtenner!!.onItemLongClick(view, position) }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return muTypeSuport?.getLayoutId(mDatas[position]) ?: super.getItemViewType(position)

    }

    /***
     * 把必须参数数据传递进去
     * @param houder
     * @param item 当前数据
     * @param position 当前索引值
     */
    protected abstract fun convert(houder: RecyclerHolder, item: T, position: Int)

    override fun getItemCount(): Int {
        return mDatas.size
    }

    fun setItemClickListenner(itemClickListenner: ItemClickListtenner) {
        this.listtenner = itemClickListenner
    }

}

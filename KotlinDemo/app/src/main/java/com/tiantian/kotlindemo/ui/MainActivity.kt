package com.tiantian.kotlindemo.ui

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.StaggeredGridLayoutManager
import com.tiantian.kotlindemo.R
import com.tiantian.kotlindemo.adapter.simpleAdapter
import com.tiantian.kotlindemo.api.ApiClient
import com.tiantian.kotlindemo.api.ApiErrorModel
import com.tiantian.kotlindemo.api.ApiResponse
import com.tiantian.kotlindemo.api.NetworkScheduler
import com.tiantian.kotlindemo.base.BaseActivity
import com.tiantian.kotlindemo.entity.GankModel
import com.tiantian.kotlindemo.entity.ResultsEntity
import com.tiantian.kotlindemo.tools.ByAlert
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
         var list= ArrayList<ResultsEntity>()
    override fun preInitView() {
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

    }
    /**
     * 点击事件
     */
    override fun initViewListener() {
        btnStart.setOnClickListener({

            onNetWork()
        })
    }
    var type:Int=0
    private fun onNetWork(){

        ApiClient.instance.apiService.listRepos("福利").compose(NetworkScheduler.compose())
                .bindUntilEvent(this, ActivityEvent.DESTROY)
                .subscribe(object : ApiResponse<GankModel>(this) {
                    override fun success(data: GankModel) {
                        btnStart.text=data.results[0].desc
                        list.addAll(data.results)

                    }
                    override fun failure(error: Int, apiErrorModel: ApiErrorModel) {

                    }
                })
        simpleAdapter.data { list }
        reycler.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        reycler.adapter= simpleAdapter
        reycler.itemAnimator = DefaultItemAnimator()
        simpleAdapter.onItemClick { position, _ -> ByAlert.alert("点击了"+list[position].desc) }

    }
}

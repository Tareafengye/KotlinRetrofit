package com.tiantian.kotlindemo.adapter

import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.tiantian.kotlindemo.R
import com.tiantian.kotlindemo.app.App
import com.tiantian.kotlindemo.entity.ResultsEntity
import com.ustory.koinsample.Adapter.KAdapterFactory.KAdapter
import com.ustory.koinsample.Adapter.KotlinAdapter

/**
 *    author : Mr.liu
 *    e-mail : Tareafengye@163.com
 *    Github: https://github.com/Tareafengye
 *    date   : 2018/12/11/0011上午 9:36
 *    desc   :
 *   version: 1.0
 */
var simpleAdapter : KotlinAdapter<ResultsEntity> = KAdapter(R.layout.item_kotlin_griel) {

    bindData { type, vh, data ->
        Glide.with(App.instance)
                .load(data.url)
                .into(vh.bindView(R.id.image_item))
    }
}
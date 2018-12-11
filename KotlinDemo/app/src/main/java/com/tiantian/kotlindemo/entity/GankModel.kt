package com.tiantian.kotlindemo.entity

import org.kesar.lazy.lazydb.annotate.ID
import java.io.Serializable

/**
 * GankModel
 * @author andyqtchen <br></br>
 * *         gank 主要的数据结构
 * *         创建日期：2017/6/5 13:36
 */
data class GankModel(
        val results:ArrayList<ResultsEntity>
       )

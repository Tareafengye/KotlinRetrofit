package com.tiantian.kotlindemo.tools
/**
 * Prevent continuous click, jump two pages
 */
class DoubleUtils {
    companion object {
        private var lastClickTime: Long = 0
        private val TIME: Long = 800
        fun isFastDoubleClick(): Boolean {
            val time = System.currentTimeMillis()
            if (time - lastClickTime < TIME) {
                return true
            }
            lastClickTime = time
            return false
        }
    }

}
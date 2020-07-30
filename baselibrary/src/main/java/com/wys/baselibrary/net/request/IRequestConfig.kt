package com.wys.baselibrary.net.request

/**
 * @author wangyasheng
 * @date 2020/7/24
 * @Describe:请求设置，包括公共参数与公共头
 */
interface IRequestConfig {
    /**
     * 公共参数
     */
    fun getCommonParams():Map<String,Any>

    /**
     * 公共头设置
     */
    fun getCommonHeaders():Map<String,String>
}
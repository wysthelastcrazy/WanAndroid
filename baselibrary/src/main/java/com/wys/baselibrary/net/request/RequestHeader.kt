package com.wys.baselibrary.net.request

/**
 * @author wangyasheng
 * @date 2020/7/24
 * @Describe:单独接口请求头
 */
class RequestHeader {
    private val mMap = HashMap<String,String>()

    /**
     * 添加头
     */
    fun addHeader(key: String, value: String): RequestHeader{
        mMap[key] = value
        return this
    }

    /**
     * 获取头信息
     */
    fun getHeaders() =  mMap

}
package com.wys.baselibrary.net.request

import com.google.gson.Gson
import java.lang.StringBuilder

/**
 * @author wangyasheng
 * @date 2020/7/24
 * @Describe:单独接口请求参数
 */
class RequestParam {
    //普通参数
    private val mParam = HashMap<String,Any>()
    //文件参数
    private val mFiles = HashMap<String,String>()

    /**
     * 获取文件参数集合
     */
    fun getFileParams() = mFiles

    /**
     * 获取普通参数集合
     */
    fun getParams() = mParam

    /**
     * 添加参数
     */
    fun addParam(key: String,value: String): RequestParam{
        mParam[key] = value
        return this
    }

    /**
     * 添加文件参数
     */
    fun addFileParam(key: String, filePath: String): RequestParam{
        mFiles[key] = filePath
        return this
    }
    /**
     * 获取json字符串类型参数
     */
    fun toJson(): String = Gson().toJson(mParam)


    /**
     * 获取get拼接参数字符串
     */
    override fun toString(): String {
        var builder = StringBuilder()
        mParam.forEach { it ->
            builder.append(it.key)
                    .append("=")
                    .append(it.value)
                    .append("&")

        }
        if (builder.isNotEmpty()){
            builder.deleteCharAt(builder.length - 1)
        }
        return builder.toString()
    }
}
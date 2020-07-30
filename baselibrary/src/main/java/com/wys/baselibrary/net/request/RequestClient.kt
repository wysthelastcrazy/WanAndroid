package com.wys.baselibrary.net.request

import android.text.TextUtils
import android.util.Log
import okhttp3.*
import java.io.File
import java.net.URLConnection
import java.util.concurrent.TimeUnit

/**
 * @author wangyasheng
 * @date 2020/7/24
 * @Describe:真正去请求网络的类
 */
class RequestClient private constructor(){
    private val okHttpClient: OkHttpClient
    private lateinit var mConfig: IRequestConfig
    init {

        val builder = OkHttpClient.Builder()
        builder.readTimeout(DEFAULT_MILLISECONDS,TimeUnit.MILLISECONDS)
        builder.writeTimeout(DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)
        builder.connectTimeout(DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)

        okHttpClient = builder.build()
    }
    companion object{
        const val DEFAULT_MILLISECONDS = 60*1000L
        private const val TAG = "RequestClient"
        val MEDIA_TYPE_PLAIN = MediaType.parse("text/plain;charset=utf-8")
        val MEDIA_TYPE_JSON = MediaType.parse("application/json;charset=utf-8")
        val MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream")

//        private var instance: RequestClient? = null
//            get() {
//                if (field == null){
//                    field = RequestClient()
//                }
//                return field
//            }
//        @Synchronized
//        fun get(): RequestClient{
//            return instance!!
//        }
        /**
         * lazy接受一个lambda并返回一个Lazy实例的函数，返回的实例可以作为实现
         * 延迟属性的委托：第一次调用get()会执行已传递给lazy()的lambda表达式并记录结果，
         * 后续调用get()只返回记录的结果
         */
        val instance: RequestClient by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
             RequestClient()
        }
    }


    /**
     * get请求
     */
    fun get(url: String,tag: String, params: RequestParam?, headers: RequestHeader?,
       callback: Callback){
        val paramStr = params?.toString()?:""

        val builder = Request.Builder()
        headers?.getHeaders()?.forEach {
            builder.addHeader(it.key,it.value)
        }

        val request = builder
                .url("$url?$paramStr")
                .get()
                .tag(tag)
                .build()

        okHttpClient.newCall(request).enqueue(callback)
    }

    /**
     * json格式参数post请求
     */
    fun postJson(url: String,tag: String, params: RequestParam?, headers: RequestHeader?,
                                                   callback: Callback){
        val requestBody = RequestBody.create(MEDIA_TYPE_JSON,params?.toJson()?:"")
        val builder = Request.Builder()
        headers?.getHeaders()?.forEach {
            builder.addHeader(it.key,it.value)
        }

        val request = builder
                .url(url)
                .tag(tag)
                .post(requestBody)
                .build()
        okHttpClient.newCall(request).enqueue(callback)
    }

    /**
     * form表单提交
     */
    fun postForm(url: String,tag: String, params: RequestParam?, headers: RequestHeader?,
                 callback: Callback){
        val requestBody = if (params?.getFileParams()?.size?:0 > 0){
            createMultipartBody(params?.getParams(),params?.getFileParams() )
        }else{
            createFormBody(params?.getParams())
        }
        val builder = Request.Builder()
        headers?.getHeaders()?.forEach {
            builder.addHeader(it.key,it.value)
        }

       val request =  builder
               .url(url)
               .tag(tag)
               .post(requestBody)
               .build()

        okHttpClient.newCall(request).enqueue(callback)
    }

    /**
     * 创建form表单请求body
     */
    private fun createFormBody( params: Map<String,Any>?): FormBody{
        val builder = FormBody.Builder()
        params?.forEach {
            builder.add(it.key,"${it.value}")
        }
        return builder.build()
    }

    /**
     * 创建多文件上传与参数混合请求数据body
     */
    private fun createMultipartBody(params: Map<String,Any>?, files: Map<String,String>?): MultipartBody{
        val builder = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
        params?.forEach {
            builder.addFormDataPart(it.key,"${it.value}")
        }
        files?.forEach{
            if (!TextUtils.isEmpty(it.value)){
                val file = File(it.value)
                if (file.exists()){
                    builder.addFormDataPart(it.key,file.name
                            , RequestBody.create(MediaType.parse(guessMimeType(file.name)),file))
                }else{
                    Log.e(TAG,"文件${it.value}不存在")
                }
            }
        }
        return builder.build()
    }

    /**
     * 根据文件名称获取文MimeType
     */
    private fun guessMimeType(fileName: String): String{
        val fileNameMap = URLConnection.getFileNameMap()
        val contentTypeFor = fileNameMap.getContentTypeFor(fileName)
        return contentTypeFor?:"application/octet-stream"
    }

    /**
     * 设置网络请求的公共参数以及公共头信息
     */
    fun setRequestConfig(config: IRequestConfig) {
        this.mConfig = config
    }

    fun getCommonParams(): Map<String,Any>{
        return mConfig?.getCommonParams()
    }
    fun getCommonHeaders():Map<String,String>{
        return mConfig?.getCommonHeaders()
    }
}
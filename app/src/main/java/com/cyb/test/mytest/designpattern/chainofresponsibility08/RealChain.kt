package com.cyb.test.mytest.designpattern.chainofresponsibility08

import java.lang.RuntimeException

class RealChain : Interceptor.Chain {
    var request: Request
    var interceptors = ArrayList<Interceptor>()
    var index: Int = 0

    var flag: Boolean = false

    constructor(request: Request, interceptors: ArrayList<Interceptor>, index: Int) {
        this.request = request
        this.interceptors = interceptors
        this.index = index
    }


    override fun request(): Request {
        return request
    }

    override fun proceed(request: Request): Response? {
        var response: Response? = null
        if (interceptors?.size!! > index) {
            flag = true
            var nextChain = RealChain(request, interceptors, index + 1)
            var interceptor = interceptors.get(index)
            response = interceptor.intercept(nextChain)
            //最后一个过滤器不需要调用proceed
            if (index != interceptors?.size - 1 && !nextChain.flag) {
                throw RuntimeException("自定义interceptor中要调用chain.proceed()方法")
            }
        }

        return response
    }


    /**
     * 最后一个过滤器，不需要调用proceed方法
     */
    class LastInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response? {
            var request = chain.request()
            var response = Response()
            response.isSuccess = true
            response.info = request.toString()
            return response
        }
    }
}



package com.cyb.test.mytest.designpattern.chainofresponsibility08

interface Interceptor {

    fun intercept(chain: Chain): Response?

    interface Chain {
        //获取当前request
        fun request(): Request

        //转发request
        fun proceed(request: Request): Response?
    }
}
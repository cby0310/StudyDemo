package com.cyb.test.mytest.designpattern.chainofresponsibility08

/**
 *经理
 */
class Manager : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response? {
        println("Manager before")

        var request = chain.request()
        request.reason+=" Manager：附议 "

        var response = chain.proceed(request)

        println("Manager after")
        return response
    }
}
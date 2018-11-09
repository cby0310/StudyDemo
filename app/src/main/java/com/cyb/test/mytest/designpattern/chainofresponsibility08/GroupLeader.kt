package com.cyb.test.mytest.designpattern.chainofresponsibility08


/**
 * 组长
 */
class GroupLeader : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response? {
        println("GroupLeader before")
        var request = chain.request()
        request.reason = "GroupLeader:表现不错"

        var response = chain.proceed(request)
        println("GroupLeader after")
        return response
    }
}
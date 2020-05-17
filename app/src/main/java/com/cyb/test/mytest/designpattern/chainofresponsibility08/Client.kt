package com.cyb.test.mytest.designpattern.chainofresponsibility08

class Client {
    fun execute(request: Request): Response? {

        var interceptors = ArrayList<Interceptor>()
        interceptors.add(GroupLeader())
        interceptors.add(Manager())


        interceptors.add(RealChain.LastInterceptor())

        var realChain = RealChain(request, interceptors, 0)
        var response = realChain.proceed(request)

        return response
    }
}
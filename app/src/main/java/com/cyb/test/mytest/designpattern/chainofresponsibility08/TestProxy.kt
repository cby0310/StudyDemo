package com.cyb.test.mytest.designpattern.chainofresponsibility08

/***
 * 责任链模式，在安卓中viewgroup事件传递就类似是一条责任链
 */
class TestProxy {
    fun main() {
        var builder: Request.Builder = Request.Builder()
        var request = builder.setName("cyb").setReason("play").setDays(1).build()

        var client = Client()
        var response = client.execute(request)
        println(response.toString())
    }
}
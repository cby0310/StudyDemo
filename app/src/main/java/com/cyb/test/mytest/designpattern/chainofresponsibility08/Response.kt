package com.cyb.test.mytest.designpattern.chainofresponsibility08

class Response {
    var isSuccess: Boolean = false
    var info: String? = ""

    override fun toString(): String {
        return "Response(isSuccess=$isSuccess, info=$info)"
    }

}
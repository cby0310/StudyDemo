package com.cyb.test.mytest.designpattern.facade15

class PhoneImpl : Phone {
    override fun dail() {
        System.err.println("打电话")
    }

    override fun hangup() {
        System.err.println("挂断电话")
    }

}

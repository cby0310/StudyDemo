package com.cyb.test.mytest.designpattern.interpreter11

/**
 * 数字表达式
 */
class NumExpression(var num: Int) : ArithmeticExpression() {
    override fun interpret(): Int {
        return num
    }
}

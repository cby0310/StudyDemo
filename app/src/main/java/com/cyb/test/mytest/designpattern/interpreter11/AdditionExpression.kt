package com.cyb.test.mytest.designpattern.interpreter11

class AdditionExpression(exp1: ArithmeticExpression, exp2: ArithmeticExpression) : OperatorExpression(exp1, exp2) {

    override fun interpret(): Int {
        return exp1.interpret() + exp2.interpret()
    }
}

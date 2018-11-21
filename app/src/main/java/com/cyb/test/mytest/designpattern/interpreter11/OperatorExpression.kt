package com.cyb.test.mytest.designpattern.interpreter11

abstract class OperatorExpression(var exp1: ArithmeticExpression, var exp2: ArithmeticExpression) :
    ArithmeticExpression() {
}
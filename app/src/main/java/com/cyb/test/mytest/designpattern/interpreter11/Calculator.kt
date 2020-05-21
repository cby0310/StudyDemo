package com.cyb.test.mytest.designpattern.interpreter11

import java.util.*

class Calculator(str: String) {
    var stack = Stack<ArithmeticExpression>()

    init {
        var strs = str.split(" ")

        var j = 0
        for (i in 0..strs.size) {

            if (j >= strs.size) break

            when (strs[j]) {
                "+" -> {
                    stack.push(
                        AdditionExpression(
                            NumExpression(strs[++j].toInt()),

                            NumExpression(stack.pop().interpret())
                        )
                    )
                }
                "-" -> {
                    stack.push(
                        SubtractionExpression(
                            NumExpression(stack.pop().interpret()),

                            NumExpression(strs[++j].toInt())
                        )
                    )
                }
                else -> {
                    stack.push(NumExpression(strs[j].toInt()))
                }
            }
            j++
        }
    }

    fun calculate(): Int {
        return stack.pop().interpret()
    }
}
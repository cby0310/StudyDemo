package com.cyb.test.mytest.kotlin

import org.junit.Test

class Test {
    @Test
    fun test() {
//        print("ddddd")
//        var demo: Demo? = Demo()
////        demo = null
//        if (demo?.test()!!) {
//            print(demo?.test()!!)
//        }
//        print(demo)
        ptr({
            println(it)
        }, "sss")
    }

    var ptr: ((Int) -> Unit, String) -> Unit = { block: (Int) -> Unit, str: String ->
        block(3123123)
        print(str)
    }


    class Demo {
        var name: String? = "1111"

        fun test(): Boolean? {
            return null
        }
    }
}

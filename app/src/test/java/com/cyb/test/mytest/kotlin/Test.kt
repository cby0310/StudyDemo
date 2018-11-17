package com.cyb.test.mytest.kotlin

import org.junit.Test

class Test{
    @Test
    fun test(){
        print("ddddd")
        var demo :Demo? = Demo()
//        demo = null
        if(demo?.test()!!){
            print(demo?.test()!!)
        }
        print(demo)
    }


    class Demo{
        var name:String? = "1111"

        fun test():Boolean?{
            return null
        }
    }
}

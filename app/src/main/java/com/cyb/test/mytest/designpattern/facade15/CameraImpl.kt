package com.cyb.test.mytest.designpattern.facade15

class CameraImpl : Camera {
    override fun open() {
        System.err.println("打开相机")
    }

    override fun takePicture() {
        System.err.println("拍照片")
    }

    override fun close() {
        System.err.println("关闭相机")
    }
}
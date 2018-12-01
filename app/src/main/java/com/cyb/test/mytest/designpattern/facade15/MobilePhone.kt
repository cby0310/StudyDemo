package com.cyb.test.mytest.designpattern.facade15

class MobilePhone {
    var mPhone = PhoneImpl()
    var mCamera = CameraImpl()

    fun dial() {
        mPhone.dail()
    }

    fun videChat() {
        mCamera.open()
        mPhone.dail()
    }

    fun hangup() {
        mPhone.hangup()
    }

    fun takePicture() {
        mCamera.open()
        mCamera.takePicture()
    }

    fun closeCamera() {
        mCamera.close()
    }
}

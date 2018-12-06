package com.cyb.test.mytest.designpattern.facade15;

/**
 * 外观模式facade,精髓在于"封装"二字，隐藏子系统细节，通过一个高层次结构为用户提供统一的API入口，减少了用户的使用成本，
 * 用户不用关心内部的具体实现，系统的灵活性也提高。
 * 像ImageLoader的封装，用户不要关心内部的网络、缓存、图片压缩，异步处理等，只需要一个load一个into方法即可
 * 取消订单的逻辑封装：1.请求接口 2.弹窗  3.调用取消接口，然后回调出去
 * 再像UMeng统计，只需要在Activity生命周期调用几个方法即可
 * <p>
 * android中ContextImpl就是外观者模式，我们只需要调startActivity方法，至于和AMS等打交道就不用我们操心了
 */
public class Test {
    public static void main(String[] args) {
        MobilePhone mobilePhone = new MobilePhone();
        //拍照
        mobilePhone.takePicture();
        //视频通话
        mobilePhone.videChat();
    }
}
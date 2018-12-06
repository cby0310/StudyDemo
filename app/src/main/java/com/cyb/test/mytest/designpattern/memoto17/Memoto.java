package com.cyb.test.mytest.designpattern.memoto17;

/**
 * Memoto："拍张照片"，备忘录类
 */
public class Memoto {
    public String mNickname;//昵称
    public int mLevel;//等级
    public int mBlood;//血量

    @Override
    public String toString() {
        return "Memoto{" +
                "mNickname=" + mNickname +
                ", mLevel=" + mLevel +
                ", mBlood=" + mBlood +
                '}';
    }
}

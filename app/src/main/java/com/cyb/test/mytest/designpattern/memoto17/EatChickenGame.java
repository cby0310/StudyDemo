package com.cyb.test.mytest.designpattern.memoto17;

/**
 * 以吃鸡游戏为例
 * Originator角色
 */
public class EatChickenGame {

    public String mNickname = "action";//昵称
    public int mLevel = 1;//等级
    public int mBlood = 100;//血量

    public EatChickenGame() {
        System.out.println("初始属性：" + toString());
    }

    public void play() {
        System.out.println("玩游戏");
        mLevel++;
        System.out.println("升级了 = " + mLevel);
        mBlood -= 40;
        System.out.println("吃枪子了 = " + mBlood);
    }

    public void quit() {
        System.out.println("退出游戏");
        System.out.println("当前属性：" + toString());
    }

    //创建备忘录
    public Memoto createMemoto() {
        Memoto memoto = new Memoto();
        memoto.mNickname = mNickname;
        memoto.mLevel = mLevel;
        memoto.mBlood = mBlood;
        return memoto;
    }

    public void restore(Memoto memoto) {
        mNickname = memoto.mNickname;
        mLevel = memoto.mLevel;
        mBlood = memoto.mBlood;
        System.out.println("恢复后的游戏属性：" + toString());
    }

    @Override
    public String toString() {
        return "EatChickenGame{" +
                "mNickname='" + mNickname + '\'' +
                ", mLevel=" + mLevel +
                ", mBlood=" + mBlood +
                '}';
    }
}

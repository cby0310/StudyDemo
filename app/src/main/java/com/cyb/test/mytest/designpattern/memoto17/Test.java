package com.cyb.test.mytest.designpattern.memoto17;

/**
 * 备忘录模式，编程中的后悔药
 * 以吃鸡游戏为例，没有直接存储EatChickenGame，对外屏蔽了对其的直接访问，而是存储了其中的数据
 * android中的运用就是Activity要回收时onSaveInstanceState、onRestoreInstanceState，其中需要注意只会存储有设置id的view元素
 */

public class Test {

    public static void main(String[] args) {
        EatChickenGame eatChickenGame = new EatChickenGame();
        //1.play
        eatChickenGame.play();

        //2.存档
        Caretaker caretaker = new Caretaker();
        caretaker.archive(eatChickenGame.createMemoto());

        //3.退出
        eatChickenGame.quit();

        //4.读档
        eatChickenGame.restore(caretaker.getMemoto());
    }
}

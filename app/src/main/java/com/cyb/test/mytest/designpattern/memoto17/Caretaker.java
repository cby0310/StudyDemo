package com.cyb.test.mytest.designpattern.memoto17;

/**
 * 管理者，管理备忘录
 */
public class Caretaker {
    private Memoto memoto;

    /**
     * 存档
     *
     * @param memoto
     */
    public void archive(Memoto memoto) {
        this.memoto = memoto;
    }

    public Memoto getMemoto() {
        return memoto;
    }
}

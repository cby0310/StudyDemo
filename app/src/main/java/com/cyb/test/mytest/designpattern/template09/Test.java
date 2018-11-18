package com.cyb.test.mytest.designpattern.template09;

/**
 * 模板模式，其实重构的时候会经常用到，父类写好了规则，具体细节交由子类具体实现。比如像重构的下载多个文件的工具类：
 * 父类统一处理多线程以及回调的逻辑，具体下载的任务子类实现。安卓中AsyncTask就是模板模式，onPreExecute、doInBackground、onPostExecute、
 * onProgressUpdate方法我们自己实现。再如最熟悉的onCreate、onStart等Activity的生命周期方法也是模板模式的实现。
 */
public class Test {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();

        System.out.println();

        Game game2 = new Football();
        game2.play();
    }
}

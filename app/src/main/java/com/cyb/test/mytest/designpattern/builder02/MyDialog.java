package com.cyb.test.mytest.designpattern.builder02;

/**
 * Created by pc on 2017/9/23.
 */

public class MyDialog {

    private String title;
    private String cancelTxt;
    private String okTxt;


    private boolean backCancelAble;
    private boolean touchCancelAble;


    private Builder builder;//或者不要这个变量，直接赋值


    public MyDialog(Builder builder) {
        this.builder = builder;
        init();
    }

    private void init() {
        if (builder.title != null) {
            title = builder.title;
        }
        if (builder.cancelTxt != null) {
            cancelTxt = builder.cancelTxt;
        }
        if (builder.okTxt != null) {
            okTxt = builder.okTxt;
        }
        backCancelAble = builder.backCancelAble;

        touchCancelAble = builder.touchCancelAble;
    }


    @Override
    public String toString() {
        return "MyDialog{" +
                "title='" + title + '\'' +
                ", cancelTxt='" + cancelTxt + '\'' +
                ", okTxt='" + okTxt + '\'' +
                ", backCancelAble=" + backCancelAble +
                ", touchCancelAble=" + touchCancelAble +
                '}';
    }

    public static final class Builder {
        private String title;
        private String cancelTxt;
        private String okTxt;


        private boolean backCancelAble;
        private boolean touchCancelAble;


        public Builder() {
        }

        public Builder(String title, String cancelTxt, String okTxt) {
            this.title = title;
            this.cancelTxt = cancelTxt;
            this.okTxt = okTxt;
        }


        public MyDialog create() {
            MyDialog myDialog = new MyDialog(this);

            return myDialog;
        }

        public Builder buildBackCancelAble(boolean b) {
            backCancelAble = b;
            return this;
        }

        public Builder buildTouchCancelAble(boolean b) {
            touchCancelAble = b;
            return this;
        }
    }
}

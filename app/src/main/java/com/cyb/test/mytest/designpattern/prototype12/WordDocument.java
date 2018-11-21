package com.cyb.test.mytest.designpattern.prototype12;

import java.util.ArrayList;

public class WordDocument implements Cloneable {

    private String text;
    private ArrayList<String> imgs = new ArrayList<>();

    public void addImg(String img) {
        imgs.add(img);
    }

    @Override
    protected WordDocument clone() throws CloneNotSupportedException {
        WordDocument wordDocument = (WordDocument) super.clone();
        wordDocument.text = text;
        wordDocument.imgs = (ArrayList<String>) imgs.clone();
        return wordDocument;
    }


    @Override
    public String toString() {
        return "WordDocument{" +
                "text='" + text + '\'' +
                ", imgs=" + imgs +
                '}';
    }
}

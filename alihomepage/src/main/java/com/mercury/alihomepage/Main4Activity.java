package com.mercury.alihomepage;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class Main4Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button = new Button(this);
        button.setText("我是插件");
        setContentView(button);
    }
}

package com.cyb.test.mytest.myview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.cyb.test.mytest.R;

public class JustifyTextViewActivity extends AppCompatActivity {

    private JustifyTextView justifyTv;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_justify_text_view);

        justifyTv = (JustifyTextView) findViewById(R.id.justifyTv);
        textView = (TextView) findViewById(R.id.textView);

        String s = getString(R.string.jsfijsdijfisfnfsdiaoni);
        s = ToDBC(s);
        justifyTv.setText(s);
        textView.setText(s);
    }


    /**
     * 半角转换为全角
     *
     * @param input
     * @return
     */
    public static String ToDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375) {
                c[i] = (char) (c[i] - 65248);
            }
        }
        return new String(c);
    }
}

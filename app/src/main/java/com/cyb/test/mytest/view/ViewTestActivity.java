package com.cyb.test.mytest.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import com.cyb.test.mytest.R;


public class ViewTestActivity extends AppCompatActivity {
    TestViewTranslation tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = (TestViewTranslation) findViewById(R.id.tv);
        print("onCreate");
        tv.post(new Runnable() {
            @Override
            public void run() {
                print("post");
            }
        });


        ViewTreeObserver viewTreeObserver = tv.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                print("onGlobalLayout");
            }
        });
        viewTreeObserver.addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
            @Override
            public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                print("onGlobalFocusChanged");
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewTestActivity.this, "click事件", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void textClick(View view) {
        Toast.makeText(this, "textview点击了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        print("onWindowFocusChanged");
    }

    private void print(String c) {
//        MyLog.e(c + ":(Measured)" + tv.getMeasuredHeight() + " -- " + tv.getMeasuredWidth());
//        MyLog.e(c + ":(Actually)" + tv.getHeight() + " -- " + tv.getWidth());
    }

    public void click(View view) {
//        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(100, View.MeasureSpec.EXACTLY);
//        int heightMeasureSpec = widthMeasureSpec;
//        view.measure(widthMeasureSpec, heightMeasureSpec);
//        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.AT_MOST);
//        int heightMeasureSpec = widthMeasureSpec;
//        view.measure(ViewGroup.LayoutParams.WRAP_CONTENT, heightMeasureSpec);

//        print("btn");


       /* ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tv, "translationX", 100);
        objectAnimator.setDuration(2000);

        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                MyLog.e("平移后  getLeft() = " + tv.getLeft());
                MyLog.e("平移后  getTranslationX() = " + tv.getTranslationX());
                MyLog.e("平移后  getX() = " + tv.getX());
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        objectAnimator.start();*/

//        tv.scrollTo(-100, -100);
//        tv.smoothScrollTo(-300, -100);

    }
}

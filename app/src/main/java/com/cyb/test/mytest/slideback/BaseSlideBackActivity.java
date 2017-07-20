package com.cyb.test.mytest.slideback;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.cyb.test.mytest.R;
import com.cyb.test.mytest.slideback.view.SlideBackParentView;

public class BaseSlideBackActivity extends AppCompatActivity implements SlideBackParentView.SlideCallback {


    private SlideBackParentView slideBackParentView;

    private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_slide_back);
        slideBackParentView = (SlideBackParentView) findViewById(R.id.slideBackParentView);
        slideBackParentView.setSlideCallback(this);

        decorView = getWindow().getDecorView();
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().getDecorView().setBackgroundDrawable(null);

    }

    @Override
    protected void onResume() {
        super.onResume();

        slideBackParentView.setScrollView(decorView);

//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(decorView, "translationX", 0, 50, 0).setDuration(1000);
//        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
//        objectAnimator.start();


    }

    @Override
    public void onFinish() {
        finish();
        Toast.makeText(this, "返回了", Toast.LENGTH_SHORT).show();
    }

    public void click(View view) {
        startActivity(new Intent(this, BaseSlideBackActivity.class));
    }
}

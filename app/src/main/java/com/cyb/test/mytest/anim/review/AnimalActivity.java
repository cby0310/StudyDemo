package com.cyb.test.mytest.anim.review;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.cyb.test.mytest.MyLog;
import com.cyb.test.mytest.R;
import com.cyb.test.mytest.anim.ViewWrapper;
import com.cyb.test.mytest.view.ViewPrint;

public class AnimalActivity extends AppCompatActivity {


    ImageView imageView;

    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        container = (FrameLayout) findViewById(R.id.container);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void start() {
//        objectAnimator2();
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView
                .getLayoutParams();
        marginLayoutParams.leftMargin += 400;
        imageView.requestLayout();

    }

    private void performAnimate() {
        ViewWrapper viewWrapper = new ViewWrapper(imageView);
        ObjectAnimator animator = ObjectAnimator.ofInt(viewWrapper, "width", 1000).setDuration(3000);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                MyLog.e("前");
                ViewPrint.print(imageView);
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                MyLog.e("后");
                ViewPrint.print(imageView);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.start();

//        AnimatorSet animationSet = new AnimatorSet();
//        animationSet.play(null);
    }

    private void objectAnimator2() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "scaleX", 2);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                MyLog.e("前：");
                print(imageView);
//                ViewConfiguration.get(AnimalActivity.this).getScaledTouchSlop();
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                MyLog.e("后：");
                print(imageView);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.setDuration(2000).start();
    }

    private void objectAnimator() {
        ValueAnimator animator = ObjectAnimator.ofFloat(1, 100);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MyLog.e("百分比：" + valueAnimator.getAnimatedFraction());
                MyLog.e("数值：" + valueAnimator.getAnimatedValue());
            }
        });
        animator.start();


        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(container, "backgroundColor", new ArgbEvaluator(),
                0xFFFFFFFF,
                0x00000000);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void translate() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 300, 0, 300);
        translateAnimation.setDuration(2000);
        Path path = new Path();
        path.lineTo(0.25f, 0.25f);
        path.moveTo(0.25f, 0f);
        path.lineTo(1f, 1f);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                MyLog.e("前：");
                print(imageView);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                MyLog.e("后：");
                print(imageView);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.startAnimation(translateAnimation);


//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
//        imageView.startAnimation(animation);
    }

    private void print(View view) {
        MyLog.e("left:" + view.getLeft());
        MyLog.e("top:" + view.getTop());
        MyLog.e("right:" + view.getRight());
        MyLog.e("bottom:" + view.getBottom());

        MyLog.e("x:" + view.getX());
        MyLog.e("translationX:" + view.getTranslationX());
        MyLog.e("y:" + view.getY());
        MyLog.e("translationY:" + view.getTranslationY());
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void rotate() {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 300, Animation.RELATIVE_TO_PARENT, 0.2f, Animation
                .RELATIVE_TO_PARENT, 0.2f);
        rotateAnimation.setDuration(2000);
        rotateAnimation.setFillAfter(true);
        Path path = new Path();
        path.lineTo(0.25f, 0.25f);
        path.moveTo(0.25f, 0.15f);
        path.lineTo(1f, 1f);
        rotateAnimation.setInterpolator(new PathInterpolator(path));
//        rotateAnimation.setInterpolator(new CycleInterpolator(2));
        imageView.startAnimation(rotateAnimation);
    }


}

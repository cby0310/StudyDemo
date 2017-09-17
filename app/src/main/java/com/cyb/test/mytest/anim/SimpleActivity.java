package com.cyb.test.mytest.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.cyb.test.mytest.MyLog;
import com.cyb.test.mytest.R;


public class SimpleActivity extends AppCompatActivity {


    ImageView imageView;
    RelativeLayout activity_simple;
    AnimatorSet animatorSet;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        imageView = (ImageView) findViewById(R.id.imageview);
        btn = (Button) findViewById(R.id.btn);
        activity_simple = (RelativeLayout) findViewById(R.id.activity_simple);
    }

    public void click(View view) {
//        if (null != animatorSet) {
//            animatorSet.cancel();
//        }
//        performAnimate2(view, view.getWidth(), view.getWidth() / 2);
//        performAnimate2(imageView, view.getWidth(), view.getWidth() / 2);
//        frameAnimalTest();
//        viewAnimTest();

        animationTest();
    }

    public void start(View view) {
//        Animation animation = new AlphaAnimation(0.2f, 1f);
//        animation.setDuration(1000);
//        animation.setRepeatCount(Animation.INFINITE);
//        animation.setRepeatMode(Animation.REVERSE);
//        imageView.startAnimation(animation);


        Toast.makeText(this, "s", Toast.LENGTH_SHORT).show();

        MyLog.e("前  imageView.getLeft() = " + imageView.getLeft());
        MyLog.e("前  imageView.getTranslationX() = " + imageView.getTranslationX());
        MyLog.e("前  imageView.getX() = " + imageView.getX());

        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(imageView, "translationX", 10);
        objectAnimator.setDuration(2000);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                MyLog.e("imageView.getLeft() = " + imageView.getLeft());
                MyLog.e("imageView.getTranslationX() = " + imageView.getTranslationX());
                MyLog.e("imageView.getX() = " + imageView.getX());

                imageView.setX(200);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        objectAnimator.start();


//        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imageView, "translationX", 100,-100);
//        objectAnimator1.start();

//        ObjectAnimator colorAnimator = ObjectAnimator.ofInt(activity_simple, "backgroundColor", 0xFFFF8080,
// 0xFF8080FF);
//        colorAnimator.setDuration(20000);
////        colorAnimator.setRepeatCount(ValueAnimator.INFINITE);
////        colorAnimator.setRepeatMode(ValueAnimator.REVERSE);
//        colorAnimator.setEvaluator(new ArgbEvaluator());
////        colorAnimator.start();
//
//        if (animatorSet == null) {
//            animatorSet = new AnimatorSet();
//            animatorSet.playSequentially(
//                    ObjectAnimator.ofFloat(imageView, "rotationX", 0, 360),
//                    ObjectAnimator.ofFloat(imageView, "rotationY", 0, 180, 520),
//                    ObjectAnimator.ofFloat(imageView, "rotation", 0, -90),
//                    ObjectAnimator.ofFloat(imageView, "translationX", 0, 90),
//                    ObjectAnimator.ofFloat(imageView, "translationY", 0, 90),
//                    ObjectAnimator.ofFloat(imageView, "scaleY", 1, 1.5f),
//                    ObjectAnimator.ofFloat(imageView, "scaleX", 1, 1.5f),
//                    ObjectAnimator.ofFloat(imageView, "alpha", 1, 0.5f, 1f)
//            );
//            animatorSet.setDuration(5000);
//
////            animatorSet.setInterpolator(new CycleInterpolator(2.2f));
//            animatorSet.addListener(new Animator.AnimatorListener() {
//                @Override
//                public void onAnimationStart(Animator animation) {
//                    MyLog.e("动画开始了");
//                }
//
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    MyLog.e("动画结束了");
//                }
//
//                @Override
//                public void onAnimationCancel(Animator animation) {
//                    MyLog.e("动画取消了");
//                }
//
//                @Override
//                public void onAnimationRepeat(Animator animation) {
//                    MyLog.e("动画重复了");
//                }
//            });
//            animatorSet.addPauseListener(new Animator.AnimatorPauseListener() {
//                @Override
//                public void onAnimationPause(Animator animation) {
//                    MyLog.e("动画暂停了");
//                }
//
//                @Override
//                public void onAnimationResume(Animator animation) {
//                    MyLog.e("动画恢复了");
//                }
//            });
//
//        }
////
//        if (animatorSet.isStarted() && animatorSet.isRunning() && !animatorSet.isPaused()) {
//            animatorSet.pause();
//        } else if (animatorSet.isPaused()) {
//            animatorSet.resume();
//        } else {
//            animatorSet.start();
//        }
    }


    private void performAnimate() {
        ViewWrapper viewWrapper = new ViewWrapper(imageView);
        ObjectAnimator.ofInt(viewWrapper, "width", 500, 300, 1000).setDuration(3000).start();
    }

    private void performAnimate2(final View target, final int start, final int end) {
        //定义一个估值器进行估值
        final IntEvaluator intEvaluator = new IntEvaluator();
        ValueAnimator valueAnimator = ValueAnimator.ofInt(1, 100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = animation.getAnimatedFraction();
                MyLog.e("当前值：" + animation.getAnimatedValue());
                MyLog.e("fraction = " + fraction);
                target.getLayoutParams().width = intEvaluator.evaluate(fraction, start, end);
                target.requestLayout();
            }
        });

        valueAnimator.setDuration(2000);
        valueAnimator.start();
    }

    private void frameAnimalTest() {
        activity_simple.setBackgroundResource(R.drawable.frame_animation);
        AnimationDrawable animationDrawable = (AnimationDrawable) activity_simple.getBackground();
        animationDrawable.start();

//        animationDrawable.stop();
    }

    private void viewAnimTest() {
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
//        animation.setDuration(200);
//        activity_simple.startAnimation(animation);

        Animation animation = new AlphaAnimation(0.2f, 1f);
        animation.setDuration(1000);
        animation.setRepeatMode(Animation.RESTART);
        animation.setFillAfter(true);
        animation.setStartOffset(10000);


        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(animation);

        animatorSet.setInterpolator(new LinearInterpolator());
    }


    private void animationTest() {

        MyLog.e("前  imageView.getLeft() = " + imageView.getLeft());
        MyLog.e("前  imageView.getTranslationX() = " + imageView.getTranslationX());
        MyLog.e("前  imageView.getX() = " + imageView.getX());


        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate2);
//        animation.setDuration(1000);

//        animation.setRepeatCount(Animation.INFINITE);
//        animation.setRepeatMode(Animation.RESTART);

//        animation.setStartOffset(1000);
        animation.setInterpolator(new LinearInterpolator());

        animation.setFillAfter(true);
//        animation.setFillBefore(true);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                MyLog.e("动画开始了");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                MyLog.e("动画结束了");

                MyLog.e("imageView.getLeft() = " + imageView.getLeft());
                MyLog.e("imageView.getTranslationX() = " + imageView.getTranslationX());
                MyLog.e("imageView.getX() = " + imageView.getX());


//                imageView.setX(200);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                MyLog.e("动画重复了");
            }
        });

        imageView.startAnimation(animation);


        MyLog.e("滑动识别距离：" + ViewConfiguration.get(this).getScaledTouchSlop());

////
//        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.alpha);
//
//        animation1.setDuration(10000);
//
//        AnimationSet animationSet = new AnimationSet(true);
//        animationSet.addAnimation(animation);
//        animationSet.addAnimation(animation1);
////        animationSet.setDuration(2000);
//        animationSet.setFillAfter(true);
//        animationSet.setRepeatCount(Animation.INFINITE);
//        animationSet.setRepeatMode(Animation.REVERSE);
//        imageView.startAnimation(animationSet);
    }


    private void animationSetTest() {

    }

}

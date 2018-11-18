package com.cyb.test.mytest.anim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.*;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

import com.bumptech.glide.Glide;
import com.cyb.test.mytest.MyLog;
import com.cyb.test.mytest.R;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ArgbEvaluator;
import com.nineoldandroids.animation.IntEvaluator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;

import java.io.ByteArrayOutputStream;

import io.reactivex.Scheduler;
import io.reactivex.plugins.RxJavaPlugins;


public class SimpleActivity extends AppCompatActivity {


    ImageView imageView, icon;
    RelativeLayout activity_simple;
    AnimatorSet animatorSet;
    Button btn;

    Handler mHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.e("Terry","handleMessage  handleMessage");
        }
    };
    Handler mHandler1 = new Handler(Looper.getMainLooper());
    Toast t;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_simple);

        //
//        Scheduler scheduler = RxJavaPlugins.createComputationScheduler(null);


        imageView = (ImageView) findViewById(R.id.imageview);
        icon = (ImageView) findViewById(R.id.icon);
        btn = (Button) findViewById(R.id.btn);
        activity_simple = (RelativeLayout) findViewById(R.id.activity_simple);

        Log.e("Terry","sendEmptyMessage before");
        mHandler.sendEmptyMessage(10);
        Log.e("Terry","sendEmptyMessage end");


        if (mHandler == mHandler1) {
        }
        if (mHandler.getLooper().getQueue() == mHandler1.getLooper().getQueue()) {

        }

//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(SimpleActivity.this, "3000", Toast.LENGTH_SHORT).show();
//                mHandler.removeCallbacksAndMessages(null);
//            }
//        }, 3000);
        new Thread() {
            @Override
            public void run() {
                super.run();
                Looper.prepare();
                t = Toast.makeText(SimpleActivity.this, "sssss", Toast.LENGTH_SHORT);
                t.show();
                t.setText(Thread.currentThread().getName() + "");
                Looper.loop();
            }
        }.start();
        Log.e("Terry","sendEmptyMessage oncreate  end");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Terry","sendEmptyMessage onresume end");
    }

    public void click(View view) {
//        if (null != animatorSet) {
//            animatorSet.cancel();
//        }
//        performAnimate2(view, view.getWidth(), view.getWidth() / 2);
//        performAnimate2(imageView, view.getWidth(), view.getWidth() / 2);
//        frameAnimalTest();
//        viewAnimTest();

//        animationTest();

//        icon.setImageResource(R.mipmap.device);
//        printBitmapSize(icon);
//
//        Toast.makeText(SimpleActivity.this, getResources().getDisplayMetrics().widthPixels + " x " + getResources()
// .getDisplayMetrics()
//                .heightPixels + " " + getResources().getDisplayMetrics().density, Toast.LENGTH_SHORT).show();
//        Log.d("Jesse", getResources().getDisplayMetrics().widthPixels + " x " + getResources().getDisplayMetrics()
//                .heightPixels);


        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap
                .a86833b6fae5a688ecbb1448e00bd69174bc8ed187cfa4a52626d297785eef9);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 10, baos);
        byte[] datas = baos.toByteArray();
        Glide.with(this).load(datas).into(icon);

//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                t.setText("48484");
//            }
//        }.start();
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

//        animate(imageView).setDuration(1000).rotationXBy(720).x(100).y(100);


        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "translationX", 100);
        final ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(imageView, "translationY", 100);
        objectAnimator.setDuration(2000);
        objectAnimator.setEvaluator(new ArgbEvaluator());
        objectAnimator2.setDuration(2000);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                valueAnimator.getAnimatedFraction();
                MyLog.e("0000 value = " + valueAnimator.getAnimatedValue());
            }
        });
        objectAnimator.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                MyLog.e("imageView.getLeft() = " + imageView.getLeft());
                MyLog.e("imageView.getTranslationX() = " + imageView.getTranslationX());
                MyLog.e("imageView.getX() = " + imageView.getX());

//                imageView.setX(200);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        objectAnimator.start();
        objectAnimator2.start();
        new Thread() {

            @Override
            public void run() {
                super.run();
                Looper.prepare();


                Looper.loop();
            }
        }.start();


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


    private void printBitmapSize(ImageView imageView) {
        if (imageView == null) return;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            Log.d("Jesse", "w:" + bitmap.getWidth() + "  h:" + bitmap.getHeight());
        } else {
            Log.d("Jesse", "drawable null ");
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        printBitmapSize(icon);
    }
}

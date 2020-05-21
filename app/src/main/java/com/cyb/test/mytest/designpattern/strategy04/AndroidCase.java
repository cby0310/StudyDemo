package com.cyb.test.mytest.designpattern.strategy04;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

import com.cyb.test.mytest.R;

/**
 * Created by pc on 2017/11/19.
 */

public class AndroidCase extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //view动画时间插值器Interpolator的实现，view动画是通过Matrix对view进行的转换，
        //所以不影响点击事件的位置

        //view.startAnimation()后会触发invalidate()方法从而导致view重绘，在view的draw()
        //方法内部会get到animation然后调用其getTransformation方法，最后会执行到特定动画比如TranslateAnimation的applyTransformation方法进行矩阵变换，另外
        //getTransformation会并返回一个布尔值标识动画是否执行完毕，若未完毕则会调用parent的invalidate()方法执行下一帧动画。
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate2);
        animation.setInterpolator(new LinearInterpolator());
        animation.setFillAfter(true);
        new View(this).startAnimation(animation);

    }
}

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
        // 所以不影响点击事件的位置
        //是在view的draw()-> applyLegacyAnimation() -> Animation#getTransformation() ->
        //getTransformation() -> Interpolator#getInterpolation() -> Animation#applyTransformation()
        //找到子类后执行对应的applyTransformation()方法进行matrix转换。
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate2);
        animation.setInterpolator(new LinearInterpolator());
        animation.setFillAfter(true);
        new View(this).startAnimation(animation);

    }
}

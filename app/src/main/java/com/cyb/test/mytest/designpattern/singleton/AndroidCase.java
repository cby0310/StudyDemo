package com.cyb.test.mytest.designpattern.singleton;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;

import com.cyb.test.mytest.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by pc on 2017/10/24.
 * android中使用案例LayoutInflater等各个系统Service的实现：单例 + 缓存
 */

public class AndroidCase extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        //内部通过XmlPullParser解析布局xml文件，采用的深度优先遍历来构造视图树：每解析到一个view就会递归调用rInflate方法，直到
        // 路径的最后一个元素，然后回溯过来将每个view添加到它们的parent中
        setContentView(R.layout.activity_battery_view);


        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(this);
        builder.diskCacheSize(1024);
        //DCL模式的单例，记得volatile关键字
        ImageLoader.getInstance().init(builder.build());
    }

    private void case1() {
        /**
         * 1.ContextImpl使用Map保存各个service，这些service在静态代码块中进行了初始化和加入map
         * 2.而且这些service也进行了缓存
         *
         * LayoutInflater是一个抽象类，具体实现类是PhoneLayoutInflater
         */
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        layoutInflater.inflate(R.layout.activity_battery_view, null);
    }
}

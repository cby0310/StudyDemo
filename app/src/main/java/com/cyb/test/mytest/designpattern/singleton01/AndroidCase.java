package com.cyb.test.mytest.designpattern.singleton01;

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
        //路径的最后一个元素，然后回溯过来将每个view添加到它们的parent中
        setContentView(R.layout.activity_battery_view);


        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(this);
        builder.diskCacheSize(1024);
        //DCL模式的单例，记得volatile关键字
        ImageLoader.getInstance().init(builder.build());
    }

    private void case1() {
        /**
         * 1.SystemServiceRegistry有一个HashMap<String, ServiceFetcher<?>>，static代码块中registerService各个服务和对应的ServiceFetcher，ServiceFetcher中createService方法会新建相应的服务，所以这里不会立即新建服务对象实例，get时才会真正创建
         * 2.ContextImpl中获取服务：SystemServiceRegistry.getSystemService().getService(),getService会先判断缓存中(这个缓存是ContextImpl中的一个数组,所以这些服务每个context中会有一份，其他还有ActivityManager、nfc等service，还有一些是不检验缓存的)是否存在，存在直接返回，不存在则在同步方法中调用createService方法创建后返回
         *
         * LayoutInflater是一个抽象类，具体实现类是PhoneLayoutInflater
         */
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        layoutInflater.inflate(R.layout.activity_battery_view, null);
    }
}

package com.cyb.test.mytest.designpattern.memoto17;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

public class AndroidCase extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        //1.保存窗口的视图树状态：window#saveHierarchyState -> decorview遍历每个view以其id为key保存其状态，没有设置id的不会保存，另一方面保存当前获取焦点的view
        //2.保存fragment状态：这就是为什么建议通过setArgument赋值的原因
        //3.调用Activity的ActivityLifeCycleCallbacks的onActivitySaveInstanceState回调，这个是全局的LifeCycle回调
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //activity#handleResumeActivity中回调
    }
}

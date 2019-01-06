package com.cyb.test.mytest.popupwindow;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.taobao.android.dexposed.DexposedBridge;
import com.taobao.android.dexposed.XC_MethodHook;
import com.taobao.android.dexposed.XposedHelpers;
import dalvik.system.DexFile;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class PopupWindowTestActivty extends Activity {
    TextView textView;


    public boolean goToChatView1() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        ComponentName cn = new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.sns.ui.SnsUploadUI");
        intent.setComponent(cn);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("/storage/emulated/0/DCIM/Screenshots/Screenshot_2018-11-20-18-02-41-863_de.robv.android.xposed.installer.png");
//        arrayList.add("/storage/emulated/0/DCIM/Screenshots/Screenshot_2018-11-20-18-02-30-351_de.robv.android.xposed.installer.png");
        arrayList.add("/storage/emulated/0/DCIM/1525935386191@2c038de.jpg");
        intent.putExtra("sns_kemdia_path_list", arrayList);
        intent.putExtra("KTouchCameraTime", 1546609208l);

        intent.putExtra("intent_key_StatisticsOplog", "weiboli-xu2011");
        intent.putExtra("sns_media_latlong_list", new ArrayList<>());
        intent.putExtra("KFilterId", 0);
        intent.putExtra("KSnsPostManu", true);

        getApplication().startActivity(intent);

        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        setContentView(linearLayout);

        textView = new TextView(this);
        textView.setText("我是锚点");

        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(textView);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToChatView1();
//                TextView textView1 = new TextView(PopupWindowTestActivty.this);
//                textView1.setText("popupwindow");
//                PopupWindow popupWindow = new PopupWindow();
//                popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
//                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
//                popupWindow.setOutsideTouchable(true);
//                popupWindow.setContentView(textView1);
//                popupWindow.showAsDropDown(textView);
            }
        });


        DexposedBridge.findAndHookMethod(DexFile.class, "loadDex", String.class, String.class, int.class, new XC_MethodHook() {
            /**
             * Called before the invocation of the method.
             * <p>Can use {@link MethodHookParam#setResult(Object)} and {@link MethodHookParam#setThrowable(Throwable)}
             * to prevent the original method from being called.
             *
             * @param param
             */
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);

                String dex = (String) param.args[0];
                String odex = (String) param.args[1];
                Log.i("PopupWindowTestActivty", "load dex, input:" + dex + ", output:" + odex);
            }
        });


        int time = 60 * 60 * 10 * 1000;

        try {
            Class<?> clazz = Class.forName("com.android.server.notification.NotificationManagerService");
            Field field = clazz.getDeclaredField("SHORT_DELAY");
            field.setAccessible(true);
            field.set(null, time);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Class serviceC = XposedHelpers.findClass("com.android.server.notification.NotificationManagerService", null);


        Toast.makeText(this, "我要弹10分钟", time).show();


    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}

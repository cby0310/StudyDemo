package com.mercury.alihomepage;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import com.mercury.material_design.R;

public class MainActivity extends Activity {

    NestedScrollView mScrollView;
    HeaderView mHeaderView;

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScrollView = findViewById(R.id.scrollView);
        mHeaderView = findViewById(R.id.headerView);

        mScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int
                    oldScrollX, int oldScrollY) {
                Log.i(TAG, "scrollY:" + scrollY);
            }
        });
        mHeaderView.setOnHeaderFlingUnConsumedListener(new HeaderView.OnHeaderFlingUnConsumedListener() {

            @Override
            public int onFlingUnConsumed(HeaderView header, int targetOffset, int unconsumed) {
                HeaderView.Behavior behavior = mHeaderView.getBehavior();
                int dy = -unconsumed;
                Log.i(TAG, "onFlingUnConsumed: " + unconsumed);
                if (behavior != null) {
                    mScrollView.scrollTo(0, dy);
                }
                return dy;
            }
        });
    }
}

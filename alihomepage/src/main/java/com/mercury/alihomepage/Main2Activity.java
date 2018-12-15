package com.mercury.alihomepage;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mercury.material_design.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    @BindView(R.id.tv_title)
    TextView                tvTitle;
    @BindView(R.id.iv1)
    ImageView               iv1;
    @BindView(R.id.iv2)
    ImageView               iv2;
    @BindView(R.id.iv3)
    ImageView               iv3;
    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.appBarLayout)
    AppBarLayout            appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int maxOffset = appBarLayout.getTotalScrollRange();
                Log.i(TAG, "max: " + maxOffset);
                Log.i(TAG, "onOffsetChanged: " + verticalOffset);

                if (maxOffset + verticalOffset == 0) {
                    iv1.setVisibility(View.VISIBLE);
                    iv2.setVisibility(View.VISIBLE);
                    iv3.setVisibility(View.VISIBLE);
                    tvTitle.setVisibility(View.GONE);
                } else {
                    iv1.setVisibility(View.GONE);
                    iv2.setVisibility(View.GONE);
                    iv3.setVisibility(View.GONE);
                    tvTitle.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}

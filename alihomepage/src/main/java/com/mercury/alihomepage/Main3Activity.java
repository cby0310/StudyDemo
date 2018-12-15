package com.mercury.alihomepage;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mercury.material_design.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity {

    @BindView(R.id.img_zhangdan)
    ImageView        imgZhangdan;
    @BindView(R.id.img_zhangdan_txt)
    TextView         imgZhangdanTxt;
    @BindView(R.id.jiahao)
    ImageView        jiahao;
    @BindView(R.id.tongxunlu)
    ImageView        tongxunlu;
    @BindView(R.id.img_shaomiao)
    ImageView        imgShaomiao;
    @BindView(R.id.img_fukuan)
    ImageView        imgFukuang;
    @BindView(R.id.img_search)
    ImageView        imgSearch;
    @BindView(R.id.img_zhaoxiang)
    ImageView        imgZhaoxiang;
    @BindView(R.id.appBarLayout)
    AppBarLayout     appBarLayout;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.toolbar)
    Toolbar          toolbar;
    @BindView(R.id.toolbar1)
    RelativeLayout   toolbar1;
    @BindView(R.id.toolbar2)
    RelativeLayout   toolbar2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    toolbar1.setVisibility(View.VISIBLE);
                    toolbar2.setVisibility(View.GONE);
                    setToolbarAlpha(255);
                }else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    //收缩
                    toolbar1.setVisibility(View.GONE);
                    toolbar2.setVisibility(View.VISIBLE);
                    setToolbarAlpha2(255);
                } else {
                    int alpha=255-Math.abs(verticalOffset);
                    if(alpha<0){
                        Log.e("alpha",alpha+"");
                        //收缩toolbar
                        toolbar1.setVisibility(View.GONE);
                        toolbar2.setVisibility(View.VISIBLE);
                        setToolbarAlpha2(Math.abs(verticalOffset));
                    }else{
                        //张开toolbar
                        toolbar.setVisibility(View.VISIBLE);
                        toolbar2.setVisibility(View.GONE);
                        setToolbarAlpha(alpha);
                    }
                }
            }


        });
    }


    private void setToolbarAlpha(int alpha) {
        imgZhangdan.setAlpha(alpha);
        imgZhangdanTxt.setTextColor(Color.rgb(255, 255, 255));
        tongxunlu.setAlpha(alpha);
        jiahao.setAlpha(alpha);

    }

    private void setToolbarAlpha2(int alpha) {
        imgShaomiao.setAlpha(alpha);
        imgFukuang.setAlpha(alpha);
        imgSearch.setAlpha(alpha);
        imgZhaoxiang.setAlpha(alpha);

    }
}

package com.cyb.test.mytest.view;

import android.content.Intent;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.EventLog;
import android.util.Printer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cyb.test.mytest.MyEventBusIndex;
import com.cyb.test.mytest.R;
import com.cyb.test.mytest.anim.SimpleActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.locks.ReentrantLock;

import static android.support.v7.widget.RecyclerView.VERTICAL;

public class RecyclerViewActivity extends AppCompatActivity {

    //    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
//        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, VERTICAL));
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(1, VERTICAL);
        layoutManager.setItemPrefetchEnabled(false);
        recyclerView.setLayoutManager(layoutManager);

        Collections.sort(new ArrayList<String>(3), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

//        recyclerView.setLayoutManager(new LinearLayoutManager(this, VERTICAL, false));
        Looper.getMainLooper().setMessageLogging(new Printer() {
            @Override
            public void println(String x) {

            }
        });

        adapter = new RecyclerView.Adapter() {

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                TextView textView = new TextView(parent.getContext());
                return new MyVH(textView);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView) holder.itemView).setText("   rv item： " + position);
                ((TextView) holder.itemView).setHeight(200);
                ((TextView) holder.itemView).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(RecyclerViewActivity.this, SimpleActivity.class));
                    }
                });
            }

            @Override
            public int getItemCount() {
                return 100;
            }

            @Override
            public int getItemViewType(int position) {
                return super.getItemViewType(position);
            }
        };

        recyclerView.getChildLayoutPosition(null);
        recyclerView.getChildAdapterPosition(null);

        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();

        EventBus eventBus = EventBus.getDefault();
        eventBus.register(this);
        eventBus.post(new EventObj("124"));
    }

    static class MyVH extends RecyclerView.ViewHolder {
        public MyVH(TextView itemView) {
            super(itemView);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100)
    public void onEvent(EventObj obj) {
        Toast.makeText(this, obj.text, Toast.LENGTH_LONG).show();
    }


    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100)
    public void onEvent22(EventObj obj) {
        Toast.makeText(this, obj.text, Toast.LENGTH_LONG).show();
    }


    static class EventObj {
        String text = "";

        public EventObj(String text) {
            this.text = text;
        }
    }
}

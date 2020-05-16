package com.cyb.test.mytest.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cyb.test.mytest.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.locks.ReentrantLock;

import static android.support.v7.widget.RecyclerView.VERTICAL;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recyclerView);
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
    }

    static class MyVH extends RecyclerView.ViewHolder {
        public MyVH(TextView itemView) {
            super(itemView);
        }
    }
}

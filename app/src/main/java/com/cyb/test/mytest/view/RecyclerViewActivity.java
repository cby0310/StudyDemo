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

import static android.support.v7.widget.RecyclerView.VERTICAL;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, VERTICAL));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, VERTICAL, false));
        adapter = new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                TextView textView = new TextView(parent.getContext());
                return new MyVH(textView);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView) holder.itemView).setText("rv item： " + position);
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

        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    static class MyVH extends RecyclerView.ViewHolder {
        public MyVH(TextView itemView) {
            super(itemView);
        }
    }
}

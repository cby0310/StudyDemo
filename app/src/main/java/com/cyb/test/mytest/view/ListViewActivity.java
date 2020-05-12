package com.cyb.test.mytest.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cyb.test.mytest.R;

public class ListViewActivity extends Activity {

    private ListView listview;

    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);

        listview = findViewById(R.id.listview);
        adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return 110;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                ViewHolder holder = null;
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = new TextView(parent.getContext());
                    holder.textView = (TextView) convertView;
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                holder.textView.setHeight(200);
                holder.textView.setText("lv item:  " + position);
                return convertView;
            }
        };
        listview.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    public static class ViewHolder {
        public TextView textView;
    }
}

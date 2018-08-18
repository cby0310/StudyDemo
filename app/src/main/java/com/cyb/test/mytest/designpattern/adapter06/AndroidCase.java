package com.cyb.test.mytest.designpattern.adapter06;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cyb.test.mytest.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by pc on 2017/11/27.
 */

public class AndroidCase extends Activity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.layout_android_case);

        //ListView要解决的问题是每一项item视图的输出，item view和输入数据类型千变万化，但终究都是view类型，Adapter统一将item view
        //输出为view，这样很好地应对了item view的可变性。输入有无数种情况，输出类型是统一的。这虽然有些脱离Adapter模式将
        //不兼容的接口转换为可用接口的使用场景，但是也是Adapter模式的一种变种实现。
        //在这里，Target就是View（ListView），Adaptee是需要被处理的Item View，Adapter将Item View输出为View抽象的角色，
        //通过获取item的个数、数据、ItemView等，从而适配各种数据各种Item视图的效果。
        BaseAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_aidl_test);
        ListView listView = new ListView(this);
        listView.setAdapter(adapter);

        adapter.notifyDataSetChanged();




        //下面是recyclerview
        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setHasFixedSize(true);
        List<String> books = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            books.add(i + "");
        }

        MyAdapter myAdapter;
        myAdapter = new MyAdapter(books, new OnItemClickListener<String>() {
            @Override
            public void onClick(View view, String s) {
                recyclerView.setLayoutManager(new GridLayoutManager(AndroidCase.this, 3));
                recyclerView.setLayoutFrozen(!recyclerView.isLayoutFrozen());
                Toast.makeText(AndroidCase.this, s, Toast.LENGTH_LONG).show();
            }
        });

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
                Paint paint = new Paint();
                paint.setColor(Color.RED);
                paint.setStrokeWidth(100);
                c.drawLine(0,100,1000,100,paint);
            }
        });

        myAdapter.setHasStableIds(true);

        recyclerView.setAdapter(myAdapter);

        //使不可滑动  冻结掉
//        recyclerView.setLayoutFrozen(true);

        for (int i = 0; i < 90; i++) {
            books.add(i + "aaaa");
        }

        myAdapter.notifyDataSetChanged();
    }

}

/**
 * 将以前adapter的getView方法拆分成了onCreateViewHolder和onBindViewHolder两个方法，就是将缓存和view两个部分做了拆分
 */
class MyAdapter extends RecyclerView.Adapter<MyAdapter.BookViewHolder> {

    List<String> books;

    OnItemClickListener<String> onItemClickListener;


    public MyAdapter(List<String> books, OnItemClickListener<String> onItemClickListener) {
        this.books = books;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    /**
     * 返回值是onCreateViewHolder方法的第二个参数
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, final int position) {
        holder.textView.setText(books.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(v, books.get(position));
                }
            }
        });
        holder.textView.getLayoutParams().height = new Random().nextInt(10) * 50 + 100;
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public BookViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }
    }
}

interface OnItemClickListener<T> {
    void onClick(View view, T t);
}

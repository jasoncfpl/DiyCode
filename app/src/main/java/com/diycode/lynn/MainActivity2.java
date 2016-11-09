package com.diycode.lynn;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends AppCompatActivity {


    RecyclerView mRecyclerView;

    List<String> mStrings = new ArrayList<>();

    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
//        mCollapsingToolbarLayout.setTitle("Title");
//
        mRecyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        for (int i = 0; i < 40; i++) {
            mStrings.add("测试"+i);
        }

        mRecyclerView.setAdapter(new MyAdapter(mStrings));


    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        List<String> mAdapterStringList = new ArrayList<>();

        MyAdapter(List<String> mAdapterStringList){
            this.mAdapterStringList = mAdapterStringList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(MainActivity2.this).inflate(R.layout.adapter_recycler_main_layout,parent,false));

            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.mTextView.setText(mAdapterStringList.get(position));
        }

        @Override
        public int getItemCount() {
            return mAdapterStringList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{

            TextView mTextView;

            public MyViewHolder(View itemView) {
                super(itemView);
                mTextView = (TextView) itemView.findViewById(R.id.recycler_textview);
            }
        }
    }
}

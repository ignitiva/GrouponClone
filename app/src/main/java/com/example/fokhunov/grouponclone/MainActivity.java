package com.example.fokhunov.grouponclone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private ContactAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Coupon> couponList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle(R.string.app_name);
            setSupportActionBar(toolbar);
        }

        mRecycleView = (RecyclerView)findViewById(R.id.cardList);
        mRecycleView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(mLayoutManager);

        for (int i =0; i < 10; i++){
            Coupon c = new Coupon("Farrukh: " + i);
            couponList.add(c);
        }

        mAdapter = new ContactAdapter(couponList);
        mRecycleView.setAdapter(mAdapter);
        mAdapter.SetOnItemClickListener(new ContactAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(i);
            }
        });

    }

}

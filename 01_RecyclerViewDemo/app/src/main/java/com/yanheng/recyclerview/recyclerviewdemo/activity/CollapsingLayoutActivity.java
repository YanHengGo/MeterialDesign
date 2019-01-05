package com.yanheng.recyclerview.recyclerviewdemo.activity;

import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ScrollView;

import com.yanheng.recyclerview.recyclerviewdemo.R;

public class CollapsingLayoutActivity extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_layout);
        collapsingToolbarLayout = ((CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout));
        toolbar = ((Toolbar) findViewById(R.id.toolbar));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout.setTitle("collapsingToolbarLayout");
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);
        collapsingToolbarLayout.setExpandedTitleColor(Color.RED);


    }
}

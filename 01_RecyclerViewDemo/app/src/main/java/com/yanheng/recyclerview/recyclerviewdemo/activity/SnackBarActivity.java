package com.yanheng.recyclerview.recyclerviewdemo.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yanheng.recyclerview.recyclerviewdemo.R;

public class SnackBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
    }

    public void showSnackbar(View view) {
        Snackbar.make(view,"我是snackbar",Snackbar.LENGTH_LONG)
                .setAction("点一点", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SnackBarActivity.this,"我被点了",Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
}

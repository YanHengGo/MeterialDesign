package com.yanheng.recyclerview.recyclerviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.yanheng.recyclerview.recyclerviewdemo.R;

public class ToolBarActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        toolbar = ((Toolbar) findViewById(R.id.toolbar));
        //可以支持actionbar
//        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToolBarActivity.this,"on toolbar navigation clicked " , Toast.LENGTH_SHORT).show();
            }
        });
        toolbar.inflateMenu(R.menu.toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item_search:
                        Toast.makeText(ToolBarActivity.this," 搜查 ",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_notification:
                        Toast.makeText(ToolBarActivity.this," 通知 ",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_setting:
                        Toast.makeText(ToolBarActivity.this," 设定 ",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_about:
                        Toast.makeText(ToolBarActivity.this," 关于 ",Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }
}

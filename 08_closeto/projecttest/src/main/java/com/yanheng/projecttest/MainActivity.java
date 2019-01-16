package com.yanheng.projecttest;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private String [] items = {"请求权限","using rxpermission"};
    private ArrayAdapter<String> arrayAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void requestPermissions(){
        int permission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE);
        if(permission != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(MainActivity.this,"申请权限",Toast.LENGTH_SHORT).show();
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.CALL_PHONE)){
                Toast.makeText(MainActivity.this,"hello , 申请权限",Toast.LENGTH_SHORT).show();
            }
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},100);
        }else{
            callPhone("08012345678");
        }
    }

    private void initView() {
        listview = (ListView) findViewById(R.id.listview);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , items);
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        requestPermissions();
                        break;
                    case 1:
                        rxPermissions();
                        break;
                    case 2:
                        break;
                }
            }
        });
    }

    private void rxPermissions() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.CALL_PHONE)
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean aBoolean) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                })
    }

    private void callPhone (String phone){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse("tel:"+phone));
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


    }
}

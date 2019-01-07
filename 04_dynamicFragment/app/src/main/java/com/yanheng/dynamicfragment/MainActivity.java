package com.yanheng.dynamicfragment;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.yanheng.dynamicfragment.fragment.ContactFragment;
import com.yanheng.dynamicfragment.fragment.DynamicFragment;
import com.yanheng.dynamicfragment.fragment.MessageFragment;
import com.yanheng.dynamicfragment.util.L;

public class MainActivity extends FragmentActivity
        implements MessageFragment.OnFragmentInteractionListener,
        ContactFragment.OnFragmentInteractionListener,
        DynamicFragment.OnFragmentInteractionListener{

    private FrameLayout frameLayout;
    private TextView contact;
    private TextView message;
    private TextView dynamic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        L.d();
        super.onCreate(savedInstanceState);
        L.d();
        setContentView(R.layout.activity_main);
        L.d();
        initView();
        changeFragment(new MessageFragment(),"我是消息界面");
        L.d();
    }

    private void initView() {
        frameLayout = ((FrameLayout) findViewById(R.id.fragment));
        contact = ((TextView) findViewById(R.id.tv_contact));
        message = ((TextView) findViewById(R.id.tv_message));
        dynamic = ((TextView) findViewById(R.id.tv_dynamic));
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new ContactFragment(),"contactFragment");
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new MessageFragment(),"messageFragment");
            }
        });
        dynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new DynamicFragment(),"DynamicFragment");
            }
        });

    }
    public void changeFragment(Fragment fragment , String tag ){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,fragment , tag);
        fragmentTransaction.commit();
    }
    @Override
    protected void onRestart() {
        L.d();
        super.onRestart();
        L.d();
    }

    @Override
    protected void onStart() {
        L.d();
        super.onStart();
        L.d();
    }

    @Override
    protected void onResume() {
        L.d();
        super.onResume();
        L.d();
    }

    @Override
    protected void onPause() {
        L.d();
        super.onPause();
        L.d();
    }

    @Override
    protected void onStop() {
        L.d();
        super.onStop();
        L.d();
    }

    @Override
    protected void onDestroy() {
        L.d();
        super.onDestroy();
        L.d();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}

package com.yanheng.staticfragment;

import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yanheng.staticfragment.fragment.LeftFragment;
import com.yanheng.staticfragment.fragment.RightFragment;

public class MainActivity extends FragmentActivity implements LeftFragment.OnFragmentInteractionListener ,RightFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

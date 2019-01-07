package com.yanheng.staticfragment;

import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yanheng.staticfragment.fragment.LeftFragment;
import com.yanheng.staticfragment.fragment.RightFragment;
import com.yanheng.staticfragment.util.L;

public class MainActivity extends FragmentActivity implements LeftFragment.OnFragmentInteractionListener ,RightFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        L.d();
        super.onCreate(savedInstanceState);
        L.d();
        setContentView(R.layout.activity_main);
        L.d();
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

    /**
     * 結果
     *
     2019-01-08 04:38:05.531 5270-5270/com.yanheng.staticfragment D/MainActivity#onCreate:16: gentest ::
     2019-01-08 04:38:05.537 5270-5270/com.yanheng.staticfragment D/MainActivity#onCreate:18: gentest ::
     2019-01-08 04:38:05.583 5270-5270/com.yanheng.staticfragment D/LeftFragment#onAttach:66: gentest ::
     2019-01-08 04:38:05.583 5270-5270/com.yanheng.staticfragment D/LeftFragment#onCreate:78: gentest ::
     2019-01-08 04:38:05.586 5270-5270/com.yanheng.staticfragment D/LeftFragment#onCreateView:88: gentest ::
     2019-01-08 04:38:05.614 5270-5270/com.yanheng.staticfragment D/MainActivity#onCreate:20: gentest ::
     2019-01-08 04:38:05.616 5270-5270/com.yanheng.staticfragment D/MainActivity#onStart:32: gentest ::
     2019-01-08 04:38:05.616 5270-5270/com.yanheng.staticfragment D/LeftFragment#onActivityCreated:98: gentest ::
     2019-01-08 04:38:05.618 5270-5270/com.yanheng.staticfragment D/LeftFragment#onStart:107: gentest ::
     2019-01-08 04:38:05.619 5270-5270/com.yanheng.staticfragment D/MainActivity#onStart:34: gentest ::
     2019-01-08 04:38:05.624 5270-5270/com.yanheng.staticfragment D/MainActivity#onResume:39: gentest ::
     2019-01-08 04:38:05.625 5270-5270/com.yanheng.staticfragment D/MainActivity#onResume:41: gentest ::
     2019-01-08 04:38:05.626 5270-5270/com.yanheng.staticfragment D/LeftFragment#onResume:113: gentest ::



     2019-01-08 04:43:03.676 5270-5270/com.yanheng.staticfragment D/MainActivity#onPause:46: gentest ::
     2019-01-08 04:43:03.677 5270-5270/com.yanheng.staticfragment D/LeftFragment#onPause:119: gentest ::
     2019-01-08 04:43:03.678 5270-5270/com.yanheng.staticfragment D/MainActivity#onPause:48: gentest ::
     2019-01-08 04:43:04.040 5270-5270/com.yanheng.staticfragment D/MainActivity#onStop:53: gentest ::
     2019-01-08 04:43:04.042 5270-5270/com.yanheng.staticfragment D/LeftFragment#onStop:125: gentest ::
     2019-01-08 04:43:04.043 5270-5270/com.yanheng.staticfragment D/MainActivity#onStop:55: gentest ::
     2019-01-08 04:43:04.044 5270-5270/com.yanheng.staticfragment D/MainActivity#onDestroy:60: gentest ::
     2019-01-08 04:43:04.046 5270-5270/com.yanheng.staticfragment D/LeftFragment#onDestroyView:131: gentest ::
     2019-01-08 04:43:04.051 5270-5270/com.yanheng.staticfragment D/LeftFragment#onDestroy:137: gentest ::
     2019-01-08 04:43:04.052 5270-5270/com.yanheng.staticfragment D/LeftFragment#onDetach:143: gentest ::
     2019-01-08 04:43:04.054 5270-5270/com.yanheng.staticfragment D/MainActivity#onDestroy:62: gentest ::     *
     */
}

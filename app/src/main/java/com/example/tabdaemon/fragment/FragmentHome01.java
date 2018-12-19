package com.example.tabdaemon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabdaemon.R;
import com.example.tabdaemon.base.BasePresentFragment;


/**
 * Created by 29083 on 2018/4/10.
 * <p>
 */

public class FragmentHome01 extends BasePresentFragment {
    private static final String TAG = "FragmentHome01";

    //private View mView;


    public static FragmentHome01 getFragment() {
        FragmentHome01 fragment = new FragmentHome01();
        return fragment;
    }


    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // View mView = inflater.inflate(R.layout.fragment_home_01, container, false);
        View mView = inflater.inflate(R.layout.fragment_home_01, null);
        Log.i(TAG, "onCreateView: ");

        return mView;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView: ");
    }
}

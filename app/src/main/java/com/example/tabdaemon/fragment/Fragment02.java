package com.example.tabdaemon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabdaemon.R;


/**
 * Created by 29083 on 2018/4/10.
 * <p>
 */

public class Fragment02 extends Fragment {
    private static final String TAG = "Fragment02";

    //private View mView;


    public static Fragment02 getFragment() {
        Fragment02 fragment = new Fragment02();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //if (mView == null) {
        View mView = inflater.inflate(R.layout.fragment02, container, false);
        Log.i(TAG, "onCreateView: ");
        //}

        return mView;
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
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView: ");
    }
}

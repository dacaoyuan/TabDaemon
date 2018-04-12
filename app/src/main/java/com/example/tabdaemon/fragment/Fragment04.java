package com.example.tabdaemon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabdaemon.R;


/**
 * Created by 29083 on 2018/4/10.
 * <p>
 */

public class Fragment04 extends Fragment {
    private static final String TAG = "Fragment04";


    public static Fragment04 getFragment() {
        Fragment04 fragment = new Fragment04();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment04, container, false);
    }


}

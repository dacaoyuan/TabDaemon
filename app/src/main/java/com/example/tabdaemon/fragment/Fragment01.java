package com.example.tabdaemon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabdaemon.R;
import com.example.tabdaemon.adapter.HomePagerAdapter;
import com.example.tabdaemon.base.BasePresentFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by 29083 on 2018/4/10.
 * <p>
 */

public class Fragment01 extends BasePresentFragment {
    private static final String TAG = "Fragment01";
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;


    public static Fragment01 getFragment() {
        Fragment01 fragment = new Fragment01();
        return fragment;
    }

   /* @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    }
*/
    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //View inflate = inflater.inflate(R.layout.fragment01, container, false);
        View inflate = inflater.inflate(R.layout.fragment01,null);
         ButterKnife.bind(this, inflate);
        //WebView webView = (WebView) inflate.findViewById(R.id.webview);
        //webView.setWebViewClient(new WebViewClient());
        //webView.loadUrl("https://www.baidu.com/");

        Log.i(TAG, "createView: ");

        initView();

        return inflate;
    }

    @Override
    protected void initData() {
        Log.i(TAG, "initData: ");
    }

    private void initView() {
        List<Fragment> fragments = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        titleList.add("今日推荐");
        fragments.add(FragmentHome01.getFragment());

        HomePagerAdapter pagerAdapter = new HomePagerAdapter(fragments, titleList,getChildFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView: ");
    }
}

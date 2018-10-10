package com.example.tabdaemon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.tabdaemon.fragment.Fragment01;
import com.example.tabdaemon.fragment.Fragment02;
import com.example.tabdaemon.fragment.Fragment03;
import com.example.tabdaemon.fragment.Fragment04;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 底部导航栏采用RadioButton
 * <p>
 * 2018-10-10 书写：搭建主框架时，直接去replace的话，不太好,因为直接去replace，每个fragment 的生命周期每次都要重新执行
 * 是很好的。
 */
public class Main6Activity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private static final String TAG = "Main6Activity";

    @BindView(R.id.rg_bottom)
    RadioGroup mRgBottom;
    @BindView(R.id.rb_home)
    RadioButton mRbHome;
    @BindView(R.id.rb_books)
    RadioButton mRbBooks;
    @BindView(R.id.rb_music)
    RadioButton mRbMusic;
    @BindView(R.id.rb_tv)
    RadioButton mRbTv;

    private FragmentManager mFragmentManager;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        ButterKnife.bind(this);
        fragments = getFragments();
        mFragmentManager = getSupportFragmentManager();
        mRgBottom.setOnCheckedChangeListener(this);
        mRbHome.setChecked(true);
        //mRgBottom.check(R.id.rb_home);//设置默认选中项,用这种方式onCheckedChanged会回调两边（慎用）

    }

   /* private Fragment01 mFragment01;
    private Fragment02 mFragment02;
    private Fragment03 mFragment03;
    private Fragment04 mFragment04;*/

    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(Fragment01.getFragment());
        fragments.add(Fragment02.getFragment());
        fragments.add(Fragment03.getFragment());
        fragments.add(Fragment04.getFragment());
        return fragments;
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                Log.i(TAG, "onCheckedChanged: 1");
                switchFragment1(fragments.get(0));
                break;
            case R.id.rb_books:
                switchFragment1(fragments.get(1));
                break;
            case R.id.rb_music:
                switchFragment1(fragments.get(2));
                break;
            case R.id.rb_tv:
                switchFragment1(fragments.get(3));
                break;

        }

    }

    public void switchFragment1(Fragment fragment) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);

        if (fragment.isAdded()) {
            Log.i(TAG, "onTabSelected: isAdded");
            transaction.show(fragment);
        } else {
            Log.i(TAG, "onTabSelected: is not Added");
            transaction.add(R.id.fl_container, fragment);
        }

        transaction.commitAllowingStateLoss();
        //transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (fragments.get(0).isAdded()) {//fragment 为空时和没有被add的，不需要做隐藏处理
            Log.i(TAG, "hideFragments: 01");
            transaction.hide(fragments.get(0));
        }
        if (fragments.get(1).isAdded()) {
            Log.i(TAG, "hideFragments: 02");
            transaction.hide(fragments.get(1));
        }
        if (fragments.get(2).isAdded()) {
            transaction.hide(fragments.get(2));
        }
        if (fragments.get(3).isAdded()) {
            transaction.hide(fragments.get(3));
        }

    }


    /**
     * 提供方法切换Fragment
     *
     * @param fragment
     */
    public void switchFragment(Fragment fragment) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        //循环的的pop回退栈（如果加入了模拟返回栈，就添加如下代码）
                /*int backStackEntryCount = fm.getBackStackEntryCount();
                while (backStackEntryCount > 0) {
                    fm.popBackStack();
                    backStackEntryCount--;
                }*/
        transaction.replace(R.id.fl_container, fragment);
        transaction.commitAllowingStateLoss();
        //transaction.commit();
    }
}

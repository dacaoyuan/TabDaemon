package com.example.tabdaemon;

import android.os.Bundle;
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


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 底部导航栏采用RadioButton(2)
 * <p>
 * 2018-10-10 书写：搭建主框架时，直接去replace的话，不太好,因为直接去replace，每个fragment 的生命周期每次都要重新执行
 * 是很好的。
 */
public class Main7Activity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        ButterKnife.bind(this);
        mFragmentManager = getSupportFragmentManager();
        mRgBottom.setOnCheckedChangeListener(this);
        mRbHome.setChecked(true);
        //mRgBottom.check(R.id.rb_home);//设置默认选中项,用这种方式onCheckedChanged会回调两边（慎用）

    }

    private Fragment01 mFragment01;
    private Fragment02 mFragment02;
    private Fragment03 mFragment03;
    private Fragment04 mFragment04;


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);


        switch (checkedId) {
            case R.id.rb_home:

                if (mFragment01 != null) {
                    Log.i(TAG, "onTabSelected: isAdded");
                    transaction.show(mFragment01);
                } else {
                    mFragment01 = Fragment01.getFragment();
                    Log.i(TAG, "onTabSelected: is not Added");
                    transaction.add(R.id.fl_container, mFragment01);
                }
                break;
            case R.id.rb_books:
                if (mFragment02 != null) {
                    transaction.show(mFragment02);
                } else {
                    mFragment02 = Fragment02.getFragment();
                    transaction.add(R.id.fl_container, mFragment02);
                }
                break;
            case R.id.rb_music:
                if (mFragment03 != null) {
                    transaction.show(mFragment03);
                } else {
                    mFragment03 = Fragment03.getFragment();
                    transaction.add(R.id.fl_container, mFragment03);
                }
                break;
            case R.id.rb_tv:
                if (mFragment04 != null) {
                    transaction.show(mFragment04);
                } else {
                    mFragment04 = Fragment04.getFragment();
                    transaction.add(R.id.fl_container, mFragment04);
                }
                break;

        }
        transaction.commitAllowingStateLoss();
        //transaction.commit();
    }


    private void hideFragments(FragmentTransaction transaction) {
        if (mFragment01 != null) {//fragment 为空时不需要做隐藏处理
            Log.i(TAG, "hideFragments: 01");
            transaction.hide(mFragment01);
        }
        if (mFragment02 != null) {
            Log.i(TAG, "hideFragments: 02");
            transaction.hide(mFragment02);
        }
        if (mFragment03 != null) {
            transaction.hide(mFragment03);
        }
        if (mFragment04 != null) {
            transaction.hide(mFragment04);
        }

    }


}

package com.example.tabdaemon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.tabdaemon.fragment.Fragment01;
import com.example.tabdaemon.fragment.Fragment02;
import com.example.tabdaemon.fragment.Fragment03;
import com.example.tabdaemon.fragment.Fragment04;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main6Activity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private static final String TAG = "Main6Activity";

    @BindView(R.id.rg_bottom)
    RadioGroup mRgBottom;

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        ButterKnife.bind(this);

        mFragmentManager = getSupportFragmentManager();
        mRgBottom.setOnCheckedChangeListener(this);
        mRgBottom.check(R.id.rb_home);//设置默认选中项
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                Log.i(TAG, "onCheckedChanged: 1");
                switchFragment(Fragment01.getFragment());
                break;
            case R.id.rb_books:
                switchFragment(Fragment02.getFragment());
                break;
            case R.id.rb_music:
                switchFragment(Fragment03.getFragment());
                break;
            case R.id.rb_tv:
                switchFragment(Fragment04.getFragment());
                break;

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

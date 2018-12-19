package com.example.tabdaemon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.ShapeBadgeItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.example.tabdaemon.fragment.Fragment01;
import com.example.tabdaemon.fragment.Fragment02;
import com.example.tabdaemon.fragment.Fragment03;
import com.example.tabdaemon.fragment.Fragment04;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 直接采用 replace 方法,每次切换到相应fragment时，fragment的生命周期都会重新执行一边
 */

public class Main2Activity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private static final String TAG = "Main2Activity";
    @BindView(R.id.bottomNavigationBar)
    BottomNavigationBar mBottomNavigationBar;

    private ArrayList<Fragment> fragments;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        initBottomNavigationBar();
        fragments = getFragments();
        setDefaultFragment(fragments.get(0));
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment(Fragment defaultFragment) {
        fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fl_content, defaultFragment);
        //transaction.addToBackStack(null);//模拟返回栈
        transaction.commit();
        //transaction.commitAllowingStateLoss();
    }


    /**
     * 初始化底部导航栏
     */
    private void initBottomNavigationBar() {


      /*  TextBadgeItem numberBadgeItem = new TextBadgeItem()
                .setBorderWidth(0)
                .setBackgroundColorResource(R.color.blue)
                .setText("4")
                .setHideOnSelect(false);

        ShapeBadgeItem shapeBadgeItem = new ShapeBadgeItem()
                .setShape(0)
                .setShapeColorResource(R.color.rad)
                .setGravity(Gravity.TOP | Gravity.END)
                .setHideOnSelect(false);*/


        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);//设置导航栏模式  MODE_DEFAULT, MODE_FIXED, MODE_SHIFTING

        //设置导航栏背景模式  BACKGROUND_STYLE_DEFAULT,BACKGROUND_STYLE_STATIC, BACKGROUND_STYLE_RIPPLE
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        //mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

        mBottomNavigationBar
                //.setActiveColor(R.color.colorAccent)
                .setInActiveColor(R.color.white)//设置未被选中的文字和图标的颜色
                .setBarBackgroundColor(R.color.bottom_navigation_color); //  white

        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "home").setActiveColorResource(R.color.colorPrimary))//setActiveColorResource 选中的文字颜色，注意：图标会跟随文字的颜色一样,但是图标有2个以上一样的，图标颜色会是默认的主题颜色
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "books").setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "music").setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "TV").setActiveColorResource(R.color.colorPrimary))
                .setFirstSelectedPosition(0)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);
    }

    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(Fragment01.getFragment());
        fragments.add(Fragment02.getFragment());
        fragments.add(Fragment03.getFragment());
        fragments.add(Fragment04.getFragment());
        return fragments;
    }

    @Override
    public void onTabSelected(int position) {
        Log.i(TAG, "onTabSelected: position=" + position);
        if (fragments != null) {
            if (position < fragments.size()) {
                fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);

                //循环的的pop回退栈（如果加入了模拟返回栈，就添加如下代码）
                /*int backStackEntryCount = fm.getBackStackEntryCount();
                while (backStackEntryCount > 0) {
                    fm.popBackStack();
                    backStackEntryCount--;
                }*/

                ft.replace(R.id.fl_content, fragment);
                ft.commit();
                //ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabUnselected(int position) {
    }

    @Override
    public void onTabReselected(int position) {

    }
}

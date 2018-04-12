package com.example.tabdaemon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.tabdaemon.fragment.Fragment01;
import com.example.tabdaemon.fragment.Fragment02;
import com.example.tabdaemon.fragment.Fragment03;
import com.example.tabdaemon.fragment.Fragment04;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */
public class Main5Activity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {
    private static final String TAG = "Main4Activity";
    @BindView(R.id.bottomNavigationBar)
    BottomNavigationBar mBottomNavigationBar;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    private ArrayList<Fragment> fragments;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ButterKnife.bind(this);
        initBottomNavigationBar();
        fragments = getFragments();
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.addOnPageChangeListener(this);

        setDefaultFragment(null);
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment(Fragment defaultFragment) {

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

    /*BottomNavigationBar 只需关注该方法的回调*/
    @Override
    public void onTabSelected(int position) {
        Log.i(TAG, "onTabSelected: position=" + position);
        mViewPager.setCurrentItem(position, false);
    }

    @Override
    public void onTabUnselected(int position) {
        Log.i(TAG, "onTabUnselected:  position=" + position);
    }

    @Override
    public void onTabReselected(int position) {}



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    /*viewPager 只需关注该方法的回调*/
    @Override
    public void onPageSelected(int position) {
        Log.i(TAG, "onPageSelected: position=" + position);
        mBottomNavigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }


    private class PagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList;

        public PagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }


}

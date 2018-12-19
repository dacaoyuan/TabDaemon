package com.example.tabdaemon.base;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


/**
 * 作者    dahu
 * 时间    17/04/12
 * 文件    wodezhuangyuan
 * 描述
 */
public abstract class BasePresentFragment extends Fragment {

    private View mViewRoot;

    protected boolean isInit = false;
    protected boolean isLoad = false;

    public String TAG;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //判断为空，为空就去加载布局，onCreateView在界面切换的时候会被多次调用,防止界面跳转回来的时候显示空白
        if (mViewRoot == null) {
            TAG = this.getClass().getSimpleName();
            mViewRoot = createView(inflater, container, savedInstanceState);
            initData();
        }

        isInit = true;
        isCanLoad();

        return mViewRoot;
    }

    //视图是否已经对用户可见，系统的方法
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoad();
    }

    /**
     * 是否可以加载数据
     * 可以加载数据的条件：
     * 1.视图已经初始化
     * 2.视图对用户可见
     */
    private void isCanLoad() {
        if (!isInit) {
            return;
        }

        if (getUserVisibleHint()) {
            lazyLoad();
            isLoad = true;
        } else {
            if (isLoad) {
                stopLoad();
            }
        }
    }


    abstract protected View createView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState);


    /**
     * 初始化控件的数据
     */
    protected abstract void initData();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isLoad = false;
    }

    /**
     * 当视图初始化并且对用户可见的时候去真正的加载数据
     */
    //protected abstract void lazyLoad();
    protected void lazyLoad() {

    }

    /**
     * 当视图已经对用户不可见并且加载过数据，如果需要在切换到其他页面时停止加载数据，可以覆写此方法
     */
    protected void stopLoad() {

    }


    protected void openActivity(Class<? extends Activity> pClass) {
        Intent intent = new Intent(getActivity(), pClass);
        startActivity(intent);
    }

    protected void openActivity(Class<? extends Activity> pClass, Bundle pBundle) {
        Intent intent = new Intent(getActivity(), pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
    }


    public String getJsonParams(String url) {
        String decodeUrl = null;
        try {
            decodeUrl = URLDecoder.decode(url, "UTF-8");
            Uri uri = Uri.parse(decodeUrl);
            return uri.getQueryParameter("json_params");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


}

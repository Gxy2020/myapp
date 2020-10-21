package com.gxy.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.gxy.myapp.R;
import com.gxy.myapp.adapter.MyPagerAdapter;
import com.gxy.myapp.entity.TabEntity;
import com.gxy.myapp.fragment.CollectFragment;
import com.gxy.myapp.fragment.HomeFragment;
import com.gxy.myapp.fragment.MyFragment;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity {
    /*定义控件对象*/
    private String[] mTitles = {"首页", "收藏", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.home_unselect, R.mipmap.collect_unselect,
            R.mipmap.my_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.home_selected, R.mipmap.collect_selected,
            R.mipmap.my_selected};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    /*获取控件对象*/
    private ViewPager viewPager;
    private CommonTabLayout commonTabLayout;

    /**
     * 初始化布局
     * @return
     */
    @Override
    protected int initLayout() {
        return R.layout.activity_home;
    }

    /**
     * 控件初始化
     */
    @Override
    protected void initView() {
        viewPager=findViewById(R.id.viewpager);
        commonTabLayout=findViewById(R.id.commonTabLayout);
    }

    /**
     * 数据的封装以及事件的监听
     */
    @Override
    protected void initData() {
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(CollectFragment.newInstance());
        mFragments.add(MyFragment.newInstance());
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        /*数据绑定*/
        commonTabLayout.setTabData(mTabEntities);
        /*点击事件*/
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                commonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),mTitles,mFragments));
    }

}
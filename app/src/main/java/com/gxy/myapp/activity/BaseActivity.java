package com.gxy.myapp.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author GUO
 * @Classname baseActivity
 * @Description TODO
 * @Date 2020/10/20 13:42
 */
public abstract   class BaseActivity extends AppCompatActivity {
    public Context mContent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContent=this;
        setContentView(initLayout());
        initView();
        initData();
    }
    /*初始化方法*/

    /**
     * 初始化布局
     * @return
     */
    protected abstract int initLayout();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 数据的封装以及事件的监听
     */
    protected abstract void initData();
    /**
     * 提示信息
     * @param msg 提示信息内容
     */
    public void showToast(String msg){
        Toast.makeText(mContent,msg,Toast.LENGTH_SHORT).show();
    }
    public void showToastSync(String msg){
        Looper.prepare();
        Toast.makeText(mContent,msg,Toast.LENGTH_SHORT).show();
        Looper.loop();
    }

    /**
     * 页面跳转
     * @param cls 所要跳转到的类
     */
    public  void navigateTo(Class cls){
        Intent intent=new Intent(mContent,cls);
        startActivity(intent);
    }

    /**
     * 存储token
     * @param key token键
     * @param val token值
     */
    protected void saveStringToSp(String key,String val){
        SharedPreferences sp=getSharedPreferences("sp_ttit",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(key,val);
        editor.commit();
    }
}

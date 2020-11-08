package com.gxy.myapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import static android.content.Context.MODE_PRIVATE;

/**
 * @author GUO
 * @Classname BaseFragment
 * @Description TODO
 * @Date 2020/11/8 16:57
 */
public class BaseFragment extends Fragment {

    /**
     * 提示信息
     * @param msg 提示信息内容
     */
    public void showToast(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
    public void showToastSync(String msg){
        Looper.prepare();
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
        Looper.loop();
    }

    /**
     * 页面跳转
     * @param cls 所要跳转到的类
     */
    public  void navigateTo(Class cls){
        Intent intent=new Intent(getActivity(),cls);
        startActivity(intent);
    }

    /**
     * 存储token
     * @param key token键
     * @param val token值
     */
    protected void saveStringToSp(String key,String val){
        SharedPreferences sp=getActivity().getSharedPreferences("sp_ttit", MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(key,val);
        editor.commit();
    }

    /**
     * 取出数据
     * @param key
     * @return
     */
    protected String getStringFromSp(String key){
        SharedPreferences sp=getActivity().getSharedPreferences("sp_ttit", MODE_PRIVATE);
        return sp.getString(key,"");
    }
}

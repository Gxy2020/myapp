package com.gxy.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gxy.myapp.activity.BaseActivity;
import com.gxy.myapp.activity.LoginActivity;
import com.gxy.myapp.activity.RegisterActivity;
//继承基类
public class MainActivity extends BaseActivity {
    private Button btnLogin;
    private Button btnRegister;
    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        btnLogin=findViewById(R.id.btnLogin);
        btnRegister=findViewById(R.id.btnRegister);
    }

    @Override
    protected void initData() {
        /*登录*/
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
                navigateTo(LoginActivity.class);
            }
        });
        /*注册*/

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this, RegisterActivity.     );
//                startActivity(intent);
                navigateTo(RegisterActivity.class);
            }
        });
    }
}
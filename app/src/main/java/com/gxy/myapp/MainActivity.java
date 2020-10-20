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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*登录*/
        btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
                navigateTo(LoginActivity.class);
            }
        });
        /*注册*/
        btnRegister=findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this, RegisterActivity.class);
//                startActivity(intent);
                navigateTo(RegisterActivity.class);
            }
        });

    }
}
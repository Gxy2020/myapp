package com.gxy.myapp.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import com.google.gson.Gson;
import com.gxy.myapp.R;
import com.gxy.myapp.api.Api;
import com.gxy.myapp.api.ApiConfig;
import com.gxy.myapp.api.TtitCallback;
import com.gxy.myapp.config.AppConfig;
import com.gxy.myapp.entity.LoginResponse;
import com.gxy.myapp.util.StringUtils;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends BaseActivity {
    private EditText etAccount;
    private EditText etPwd;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*获取控件对象*/
        etAccount=findViewById(R.id.et_account);
        etPwd=findViewById(R.id.et_pwd);
        btnLogin=findViewById(R.id.btn_login);
        /*登录点击事件*/
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account=etAccount.getText().toString().trim();//获取输入框内容,.trim()把前后空格去掉
                String pwd=etPwd.getText().toString().trim();//获取输入框内容,.trim()把前后空格去掉
                login(account,pwd);
            }
        });
    }
    private void login(String account,String pwd) {
        if (StringUtils.isEmpty(account)){
            showToast("请输入账号");
            return;
        }
        //验证输入密码
        if (StringUtils.isEmpty(pwd)){
            showToast("请输入密码");
            return;
        }
        HashMap<String,Object> params=new HashMap();
        params.put("mobile","account");
        params.put("password","pwd");
        Api.config(ApiConfig.LOGIN,params).postRequest(new TtitCallback() {
            @Override
            public void onSuccess(final String res) {
                Log.e("onSuccess",res);
//                showToastSync(res);
                Gson gson=new Gson();
                LoginResponse loginResponse=gson.fromJson(res,LoginResponse.class);
                if (loginResponse.getCode()==0){
                    String token=loginResponse.getToken();
//                    SharedPreferences sp=getSharedPreferences("sp_ttit",MODE_PRIVATE);
//                    SharedPreferences.Editor editor=sp.edit();
//                    editor.putString("token",token);
//                    editor.commit();
                    saveStringToSp("token",token);
                    navigateTo(HomeActivity.class);
                    showToastSync("登录成功");
                }else {
                    showToastSync("登陆失败");
                }

//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        showToast(res);
//                    }
//                });
            }

            @Override
            public void onFailure(Exception e) {
                Log.e("onFailure",e.getMessage());
            }
        });
    }
   /* private void login(String account,String pwd) {
        //验证输入密码
        if (StringUtils.isEmpty(account)){
//            Toast.makeText(this,"请输入账号",Toast.LENGTH_SHORT).show();
            showToast("请输入账号");
            return;
        }
        //验证输入密码
        if (StringUtils.isEmpty(pwd)){
//            Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
            showToast("请输入密码");
            return;
        }
        //1.创建OKHttpClient
        OkHttpClient client=new OkHttpClient.Builder().build();
        Map map=new HashMap();
        map.put("mobile","account");
        map.put("password","pwd");
        JSONObject jsonObject=new JSONObject(map);
        String jsonStr=jsonObject.toString();
        //2.创建RequestBody
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                jsonStr);
        //3.创建Request
        Request request=new Request.Builder()
                .url(AppConfig.BASE_URL+"/app/login")
                .addHeader("contentType","application/json;charset=UTF-8")
                .post(requestBody)
                .build();
        //4.创建call回调对象
        final Call call=client.newCall(request);
        //5.发起请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onFailure",e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result=response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast(result);
                    }
                });
            }
        });
    }*/

}
package com.gxy.myapp.api;

import android.util.Log;

import com.gxy.myapp.config.AppConfig;
import com.gxy.myapp.util.StringUtils;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author GUO
 * @Classname Api
 * @Description TODO
 * @Date 2020/10/20 17:18
 */
public class Api {
    private static OkHttpClient client;
    private static String requestUrl;
    private static HashMap<String,Object>mParams;
    public static Api api=new Api();
    public Api(){
    }
    public static Api config(String url, HashMap<String,Object>params){
        //1.创建OKHttpClient
        client=new OkHttpClient.Builder().build();
        requestUrl=ApiConfig.BASE_URL+url;
        mParams=params;
        return api;
    }
    public  void postRequest(final TtitCallback callback){
        JSONObject jsonObject=new JSONObject(mParams);
        String jsonStr=jsonObject.toString();
        //2.创建RequestBody
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                jsonStr);
        //3.创建Request
        Request request=new Request.Builder()
                .url(requestUrl)
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
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result=response.body().string();
                callback.onSuccess(result);
            }
        });
    }

    public void getRequest(final  TtitCallback callback){
        String url=getAppendUrl(requestUrl,mParams);
        Request request=new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call=client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onFailure",e.getMessage());
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result=response.body().string();
                callback.onSuccess(result);
            }
        });
    }
    /*拼接URL*/
    private String getAppendUrl(String url, Map<String, Object> map) {
    if (map!=null && !map.isEmpty()){
        StringBuffer buffer=new StringBuffer();
        Iterator<Map.Entry<String,Object>>iterator=map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Object> entry=iterator.next();
            if (StringUtils.isEmpty(buffer.toString())){
                buffer.append("?");
            }else {
                buffer.append("&");
            }
            buffer.append(entry.getKey()).append("=").append(entry.getValue());
        }
        url+=buffer.toString();
    }
    return url;

    }

}

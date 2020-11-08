package com.gxy.myapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.gxy.myapp.R;
import com.gxy.myapp.activity.LoginActivity;
import com.gxy.myapp.adapter.VideoAdapter;
import com.gxy.myapp.api.Api;
import com.gxy.myapp.api.ApiConfig;
import com.gxy.myapp.api.TtitCallback;
import com.gxy.myapp.entity.VideoEntity;
import com.gxy.myapp.entity.VideoListResponse;
import com.gxy.myapp.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoFragment extends BaseFragment {

    private String title;
    private RecyclerView recyclerView;

    public VideoFragment() {
        // Required empty public constructor
    }

    public static VideoFragment newInstance(String title) {
        VideoFragment fragment = new VideoFragment();
        fragment.title=title;
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_video, container, false);
         recyclerView=v.findViewById(R.id.recyclerView);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*线性布局管理器*/
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        /*模拟虚拟数据*/
     /*   List<VideoEntity>data=new ArrayList<>();
        for (int i=0;i<6;i++){
            VideoEntity ve=new VideoEntity();
            ve.setTitle("一个面向开源及私有软件项目的托管平台");
            ve.setName("GitHub");
            ve.setDzCount(i*3);
            ve.setCommentCount(i*4);
            ve.setCollectCount(i*5);
            data.add(ve);
        }*/
     getVideoList();


    }
    private void getVideoList(){
        String token=getStringFromSp("token");
        if (!StringUtils.isEmpty(token)){
        HashMap<String,Object>params=new HashMap<>();
        params.put("token",token);
        Api.config(ApiConfig.VIDEO_LIST,params).getRequest(new TtitCallback() {
            @Override
            public void onSuccess(String res) {
                /*请求成功绑定适配器*/
//                VideoAdapter videoAdapter=new VideoAdapter(getActivity(),data);
//                recyclerView.setAdapter(videoAdapter);
                VideoListResponse response=new Gson().fromJson(res,VideoListResponse.class);
                if (response!=null&&response.getCode()==0){
                    List<VideoEntity>data=response.getPage().getList();
                    VideoAdapter videoAdapter=new VideoAdapter(getActivity(),data);
                    recyclerView.setAdapter(videoAdapter);
                }
//                showToastSync(res);
            }

            @Override
            public void onFailure(Exception e) {
                Log.e("onFailure",e.getMessage());
            }
        });
        }else {
            navigateTo(LoginActivity.class);
        }
    }
}
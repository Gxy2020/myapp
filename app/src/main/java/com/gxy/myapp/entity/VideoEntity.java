package com.gxy.myapp.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * @author GUO
 * @Classname VideoEntity
 * @Description TODO
 * @Date 2020/11/7 19:07
 */
@Data
public class VideoEntity implements Serializable {
    /**
     * vid : 1
     * vtitle : 青龙战甲搭配机动兵，P城上空肆意1V4
     * author : 狙击手麦克
     * coverurl : http://sf3-xgcdn-tos.pstatp.com/img/tos-cn-i-0004/527d013205a74eb0a77202d7a9d5b511~tplv-crop-center:1041:582.jpg
     * headurl : https://sf1-ttcdn-tos.pstatp.com/img/pgc-image/c783a73368fa4666b7842a635c63a8bf~360x360.image
     * commentNum : 121
     * likeNum : 123
     * collectNum : 122
     * playurl : http://vfx.mtime.cn/Video/2019/02/04/mp4/190204084208765161.mp4
     * createTime : 2020-07-14 11:21:45
     * updateTime : 2020-07-19 12:05:33
     * categoryId : 1
     * categoryName : 游戏
     * videoSocialEntity : null
     */

    private int vid;
    private String vtitle;
    private String author;
    private String coverurl;
    private String headurl;
    private int commentNum;
    private int likeNum;
    private int collectNum;
//    private String playurl;
//    private String createTime;
//    private String updateTime;
//    private int categoryId;
//    private String categoryName;
//    private Object videoSocialEntity;
}

package com.gxy.myapp.api;

/**
 * @author GUO
 * @Classname TtitCallbacck
 * @Description TODO
 * @Date 2020/10/20 17:15
 */
public interface TtitCallback {
    void onSuccess(String res);
    void onFailure(Exception e);

}

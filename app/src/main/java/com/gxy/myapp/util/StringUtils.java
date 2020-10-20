package com.gxy.myapp.util;

/**
 * @author GUO
 * @Classname StringUtils
 * @Description TODO
 * @Date 2020/10/20 13:37
 */
public class StringUtils {
    public static boolean isEmpty(String str){
        if (str==null||str.length()<=0){
            return true;
        }else {
            return false;
        }
    }
}

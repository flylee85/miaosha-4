package com.itheima.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.digester.Digester;

public class MD5Util {
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    //一个和客户端一样的盐值
    private static final String salt="1a2b3c4d";

    public static String inputPassToFormPass(String inputPass){
        String str=""+salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
    return md5(str);
    }


    public static String formPassToDBPass(String formPass,String salt){
        String str=""+salt.charAt(0)+salt.charAt(2)+formPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    public static void main(String[] args) {
        System.out.println("inputPassFormPass(\"123456\") = " + inputPassToFormPass("123456"));
        System.out.println("formPassDBPass() = " + formPassToDBPass(inputPassToFormPass("123456"),"1a2b3c4d"));
    }

}

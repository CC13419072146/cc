//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.furniture.shopping.utils;

import com.furniture.shopping.common.Constant;
import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    public MD5Utils() {
    }

    public static String getMD5Str(String strValue) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance(Constant.MDType);
        return Base64.encodeBase64String(md5.digest((strValue + Constant.SALT).getBytes()));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(getMD5Str("root"));
    }
}

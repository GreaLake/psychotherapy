package cn.lake.psychotherapy.utils;

/**
 * @Author: lake
 * @Date: 2022/4/21 15:18
 * @Description:
 */

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具
 */
public class MD5Util {
    public static String getMD5Str(String val) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return Base64.encodeBase64String(md5.digest((val+ Constant.SALT).getBytes()));
    }
}
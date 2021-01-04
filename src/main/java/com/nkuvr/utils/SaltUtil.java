package kaizen.shiro.utils;

import java.util.Random;

/**
 * 生成随机 salt 工具类
 *
 * @Author: weizujie
 * @Date: 2020/12/6
 * @Github: https://github.com/weizujie
 */
public class SaltUtil {

    public static String getSalt(int n) {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char a = chars[new Random().nextInt(chars.length)];
            stringBuffer.append(a);
        }
        return stringBuffer.toString();
    }
}

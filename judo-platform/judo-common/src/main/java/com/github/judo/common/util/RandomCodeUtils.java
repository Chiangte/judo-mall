package com.github.judo.common.util;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 类描述
 * @Date: 2018/11/3 14:09
 * @Version: 1.0
 */
public class RandomCodeUtils {

    private static final String SYMBOLS = "0123456789"; // 数字

    // 字符串
    // private static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final Random RANDOM = new SecureRandom();

    /**
     * 生成随机码值，包含数字、大小写字母
     *
     * @param number 生成的随机码位数
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/11/3 14:10
     * @return:
     */
    public static String getRandomCode(int number) {
        String codeNum = "";
        int[] code = new int[3];
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            int num = random.nextInt(10) + 48;
            int uppercase = random.nextInt(26) + 65;
            int lowercase = random.nextInt(26) + 97;
            code[0] = num;
            code[1] = uppercase;
            code[2] = lowercase;
            codeNum += (char) code[random.nextInt(3)];
        }
        return codeNum;
    }

    /**
     * 获取长度为 6 的随机数字
     *
     * @param:
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/11/3 14:31
     * @return: 随机数字
     */
    public static String getNonce() {

        char[] nonceChars = new char[6];

        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }

        return new String(nonceChars);
    }

    public static void main(String[] args) {
        System.out.println(getRandomCode(4));
        System.out.println(getNonce());
    }
}

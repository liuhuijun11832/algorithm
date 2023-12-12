package com.joy.bitmap;

import com.google.common.collect.Maps;

import java.util.Map;

public class BlackMobile {
    private static final Map<String, int[]> blackMobiles = Maps.newHashMapWithExpectedSize(5);
    private static final int MAX = 99999999;

    public static void main(String[] args) {
        set("15510539851");
        set("15880201334");
        set("17688103049");
        System.out.println("15510539851：" + find("15510539851"));
        System.out.println("13999192493：" + find("13999192493"));
    }

    public static boolean find(String mobile) {
        if (mobile.length() > 11) {
            return false;
        }
        return get(mobile.substring(0, 3), Integer.parseInt(mobile.substring(3)));
    }

    public static void set(String mobile) {
        if (mobile.length() > 11) {
            return;
        }
        String prefix = mobile.substring(0, 3);
        int[] bytes = blackMobiles.computeIfAbsent(prefix, k -> new int[(MAX / 32) + 1]);
        int n = Integer.parseInt(mobile.substring(3));
        int byteIndex = n / 32;
        int bitIndex = n % 32;
        bytes[byteIndex] |= 1 << bitIndex;
    }

    public static boolean get(String prefix, int n) {
        if (n > MAX) {
            return false;
        }
        int byteIndex = n / 32;
        int bitIndex = n % 32;
        int[] bytes = blackMobiles.get(prefix);
        if (bytes == null) {
            return false;
        }
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }

}

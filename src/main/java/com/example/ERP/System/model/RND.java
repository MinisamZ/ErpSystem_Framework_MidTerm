package com.example.ERP.System.model;

import org.apache.commons.math3.random.RandomDataGenerator;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RND {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";

    private static final String DATA_FOR_RANDOM_STRING_WITH_NUMS = CHAR_LOWER + CHAR_UPPER + NUMBER;
    private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER;

    private static Random r = new SecureRandom();


    public static String rndStr(int length) {
        if (length < 1) {
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            int rndCharAt = r.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);

        }

        return sb.toString();

    }

    public static int rndInt(int max) {
        if (max == 0) {
            return 0;
        }

        int ret;
        do {
            ret = r.nextInt(max);
        } while (ret < 0);
        return ret;
    }

    public static int rndInt(int min, int max) {
        int ret;
        do {
            ret = r.nextInt(max);
        } while (ret < min);
        return ret;
    }


    public static Double rndDouble(Double max) {
        Double ret;
        do {
            ret = r.nextDouble();
        } while (ret < 0 || max < ret);
        return ret;
    }

    public static Long rndLong(long min, long max) {
        return new RandomDataGenerator().nextLong(min, max);
    }

    public static Long rndLong(long max) {
        return new RandomDataGenerator().nextLong(0l, max);
    }


    public static boolean rndBool() {
        return r.nextBoolean();
    }


    public static <E extends Enum<E>> E rndEnum(E... values) {
        if (values == null || values.length == 0) {
            return null;
        }
        return values[rndInt(values.length - 1)];
    }


    public static String rndStrInt(int len) {

        String ret = "";
        while (!(ret.length() > len)) {
            long l = r.nextLong();
            if (l < 0) {
                l *= -1;
            }
            ret += l;
        }
        return ret.substring(0, len);
    }

    public static String rndEmail() {
        return RND.rndStr(8) + "@" + RND.rndStr(3) + "." + rndStr(2);
    }

    public static String rndURL() {
        return "http://" + RND.rndStr(10) + "." + rndStr(3);
    }


    public static String rndNumStr(Long from, Long to) {
        return rndNumStr(from, to, 0);
    }

    public static String rndNumStr(Long from, Long to, int length) {
        Long num = ThreadLocalRandom.current().nextLong(from, to + 1);
        if (length <= 0) {
            return num + "";
        }
        return String.format("%0" + length + "d", num);
    }

    public static String getOneOf(String[] values) {
        return values[new Integer(rndNumStr(0L, new Long(values.length) - 1))];
    }

}

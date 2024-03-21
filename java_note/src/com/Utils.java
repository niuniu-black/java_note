package com;

public class Utils {

    private Utils() {
    }

    public static String getType(Object obj) {
        return obj.getClass().toString();
    }

    public static void pr(Object obj) {
        System.out.println(obj);
        return;
    }
}

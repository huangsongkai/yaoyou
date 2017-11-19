package com.yaoyou.util;

import java.util.UUID;

/**
 * Created by song on 16/7/26.
 */
public class IdGenrator {
    public static String next(){
        return UUID.randomUUID().toString();
    }
}

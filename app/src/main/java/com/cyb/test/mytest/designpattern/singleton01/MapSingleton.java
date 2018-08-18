package com.cyb.test.mytest.designpattern.singleton01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 2017/10/24.
 * 利用容器实现单例
 */

public class MapSingleton {
    private static Map<String, Object> objectMap = new HashMap<>();

    public static void registerService(String key, Object instance) {
        if (!objectMap.containsKey(key)) {
            objectMap.put(key, instance);
        }
        Integer integer = 2;
    }

    public static Object getInstence(String key) {
        return objectMap.get(key);
    }

}

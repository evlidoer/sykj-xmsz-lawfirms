package com.jt.lawfirm.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author 李阳
 */
public class Myoc {
    
    private Myoc() {}

    private static class concurrentHashMap {
    	 private static Map<String, Object> CONCURRENTHASHMAP = new ConcurrentHashMap<>();
    }

    public static Map<String, Object> Ioc() {
        return concurrentHashMap.CONCURRENTHASHMAP;
    }
}
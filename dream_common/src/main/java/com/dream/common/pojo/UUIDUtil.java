package com.dream.common.pojo;

import java.util.Random;

public class UUIDUtil {

    public static long getItemId(){
        //带到当前的时间戳
        long millis = System.currentTimeMillis();
        //加上一个随机的两位数在0~100之间
        int i = new Random().nextInt(99);
        //在可能生成的是不足两位是前面补0
        String id=millis+String.format("%02d", i);
        return new Long(id);
    }
}

package com.atguigu;

import redis.clients.jedis.Jedis;

import java.util.*;

public class Demo01 {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.1.102", 6379);
        System.out.println("connection is ok=====>" + jedis.ping());
        //key

        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        String s = jedis.get("a");
        System.out.println(s);

        for (Iterator iterator = keys.iterator(); iterator.hasNext(); ) {
            String key = (String) iterator.next();
            System.out.println(key);
        }
        System.out.println("jedis.exists====>" + jedis.exists("b"));
        System.out.println(jedis.ttl("b"));

       //  查看键对应的数据的类型
        String a = jedis.type("a");
        System.out.println(a);

//hash
        System.out.println(jedis.hget("hash1","userName"));
        Map<String,String> map = new HashMap<String,String>();
        map.put("telphone","13810169999");
        map.put("address","atguigu");
        map.put("email","abc@163.com");
        jedis.hmset("hash2",map);
        List<String> result = jedis.hmget("hash2", "telphone","email");
        for (String element : result) {
            System.out.println(element);
        }

        System.out.println("第一次修改操作");

    }
}

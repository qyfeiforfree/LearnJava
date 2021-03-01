package com.qyfei;

import redis.clients.jedis.Jedis;

import java.util.Set;


public class jedisdel {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
     /*   Jedis jedis = new Jedis("172.28.38.42", 7000);
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
        Set<String> keys = jedis.keys("*39B0account-id-new*");
        for (String key : keys) {

            jedis.del(key);
            System.out.println(key);
        }
*/
        Person p = new Person();
        System.out.println(p instanceof Person); // true

        Student s = new Student();
        System.out.println(s instanceof Student);
    }
}
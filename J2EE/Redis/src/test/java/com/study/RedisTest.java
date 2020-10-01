package com.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 周
 * @title RedisTest
 * @date 2020/6/30 16:32
 * @description
 */
public class RedisTest {

    private Jedis jedis;

    @Before
    public void before() {
        jedis = new Jedis("127.0.0.1", 6379);
    }

    @Test
    public void testCrud() {
        // 测试插入
        String res = jedis.set("address", "Hubei");
        System.out.println("insert-->" + res);
        // 测试查询
        String get = jedis.get("address");
        System.out.println("select-->" + get);
        // 测试修改
        String set = jedis.set("address", "China");
        System.out.println("update-->" + set);
        // 测试查询
        String get2 = jedis.get("address");
        System.out.println("select-->" + get2);
        // 测试删除
        Long del = jedis.del("address");
        System.out.println("delete-->" + del);
        // 测试查询
        String get3 = jedis.get("address");
        System.out.println("select-->" + get3);
    }

    @Test
    public void testCluster(){
        Set<HostAndPort> hostAndPortSet=new HashSet<>();
        hostAndPortSet.add(new HostAndPort("127.0.0.1",7001));
        hostAndPortSet.add(new HostAndPort("127.0.0.1",7002));
        hostAndPortSet.add(new HostAndPort("127.0.0.1",7003));
        hostAndPortSet.add(new HostAndPort("127.0.0.1",7004));
        hostAndPortSet.add(new HostAndPort("127.0.0.1",7005));
        hostAndPortSet.add(new HostAndPort("127.0.0.1",7006));
        JedisCluster jedisCluster=new JedisCluster(hostAndPortSet);
        jedisCluster.get("address");
    }

    @After
    public void after() {
        jedis.close();
    }

}

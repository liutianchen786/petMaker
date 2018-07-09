package com.luke.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

 public class RedisCacheTransfer {
     
    @Autowired
    private JedisPool jedisPool = new JedisPool();
     
    private static Logger log = Logger.getLogger(RedisCacheTransfer.class);  
     //从redis缓存中查询，反序列化
     public Object getDataFromRedis(String redisKey){
         //查询
         Jedis jedis = jedisPool.getResource();
         byte[] result = jedis.get(redisKey.getBytes());
         
         //如果查询没有为空
         if(null == result){
             return null;
         }
         
         //查询到了，反序列化
         return SerializeUtil.unserialize(result);
     }
     
     //将数据库中查询到的数据放入redis
     public void setDataToRedis(String redisKey, Object obj){
         
         //序列化
         byte[] bytes = SerializeUtil.serialize(obj);
         
         //存入redis
         Jedis jedis = jedisPool.getResource();
         String success = jedis.set(redisKey.getBytes(), bytes);
         
         if("OK".equals(success)){
        	 log.info("数据成功保存到redis...");
         }
     }
}
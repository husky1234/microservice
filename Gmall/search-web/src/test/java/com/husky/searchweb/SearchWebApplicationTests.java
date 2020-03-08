package com.husky.searchweb;

import com.husky.searchweb.entity.BaseCatalog3;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.BAD_CONTEXT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Set;


@SpringBootTest
class SearchWebApplicationTests {
    @Resource
    RedisTemplate<String,Object> redisTemplate;
    @Test
    void contextLoads() {
    }

    @Test
    void redisPractice() {
        redisTemplate.opsForValue().set("test","hello");
    }
    @Test
    void redisPractice2(){
        BaseCatalog3 baseCatalog3 = new BaseCatalog3();
        baseCatalog3.setId(1L);
        baseCatalog3.setName("游戏");
        baseCatalog3.setCatalog2Id(3L);
        redisTemplate.opsForHash().put("catalog2","test1",baseCatalog3);
    }

    @Test
    void redisPractice3(){
        Set<Object> catalog1 = redisTemplate.opsForHash().keys("catalog1");
        for (Object o : catalog1) {
            System.out.println((BaseCatalog3)o);
        }
    }
    @Test
    void redisPractice4(){
        Boolean catalog = redisTemplate.delete("catalog2");
        if (catalog){
            System.out.println("删除成功！");
        }else {
            System.out.println("删除失败！");
        }
    }
    @Test
    void redisPractice5(){
        Object o = redisTemplate.opsForHash().get("catalog2", "test1");
        System.out.println((BaseCatalog3)o);
    }

}

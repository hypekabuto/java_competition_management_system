package cms.java_competition_management_system.controller;

import cms.java_competition_management_system.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private RedisCache redisCache;
    @GetMapping("test01")
    @PreAuthorize("hasAuthority('trainList')")
    public String test01(){
        return "trainList";
    }
    @GetMapping("test02")
    @PreAuthorize("hasAuthority('forumList')")
    public String test02(){
        Object cacheObject = redisCache.getCacheObject("login:" + "1");
        System.out.println("redis的数据是："+cacheObject);
        return "forumList";
    }

}

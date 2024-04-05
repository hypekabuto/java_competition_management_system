package cms.java_competition_management_system;

import cms.java_competition_management_system.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

@SpringBootTest
class JavaCompetitionManagementSystemApplicationTests {
    @Autowired
    public PasswordEncoder passwordEncoder;
    @Test
    public void contextLoads() {
        String password = "1234";
        String result = passwordEncoder.encode(password);
        System.out.println(result);
        boolean isTrue = passwordEncoder.matches(password, result);
        System.out.println(isTrue);
    }
    @Autowired
    public JwtUtil jwtUtil;
    @Test
    public void test01(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",1L);
        map.put("userName","蒜头");
        map.put("perms", Arrays.asList("p1","p2","p3"));
        String token = jwtUtil.createToken(map);
        System.out.println("token======>" + token);
    }
    @Test
    public void test02(){
        Claims claims = jwtUtil.parseToken("eyJhbGciOiJIUzI1NiJ9.eyJwZXJtcyI6WyJwMSIsInAyIiwicD" +
                "MiXSwiaWQiOjEsInVzZXJOYW1lIjoi6JKc5aS0IiwiZXhwIjoxNzExNTkxODc3LCJpYXQiOjE3MTE1O" +
                "TAwNzd9.8Lj6_TwM9MPUSs79crNa3ZqtbZd9nBEwoCFUUdoOrAc");
        System.out.println("claims=====>" + claims);
    }

}

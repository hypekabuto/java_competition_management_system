package cms.java_competition_management_system.filter;

import cms.java_competition_management_system.entity.User;
import cms.java_competition_management_system.utils.JwtUtil;
import cms.java_competition_management_system.utils.RedisCache;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.*;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private RedisCache redisCache;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if(token == null){
            doFilter(request,response,filterChain);
            return;
        }
        Claims claims = null;
        try {
            claims = jwtUtil.parseToken(token);
        }catch (SignatureException e){
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("验签失败");
            return;
        }
        Integer userId = claims.get("id", Integer.class);
        Object cacheObject = redisCache.getCacheObject("login:" + userId);
        System.out.println(cacheObject);
        if(cacheObject == null){
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("尚未登陆");
            return;
        }
        String userName = claims.get("userName", String.class);
        String stuId = claims.get("stuId", String.class);
        String avatar = claims.get("avatar", String.class);
        List<String> perms = claims.get("perms", ArrayList.class);
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setAvatar(avatar);
        user.setStuId(stuId);
        user.setPerms(perms);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        doFilter(request,response,filterChain);
    }
}

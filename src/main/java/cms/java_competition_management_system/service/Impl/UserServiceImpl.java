package cms.java_competition_management_system.service.Impl;

import cms.java_competition_management_system.entity.InDTO.LoginDTO;
import cms.java_competition_management_system.entity.OutDTO.UserDeatilOutDTO;
import cms.java_competition_management_system.entity.Role;
import cms.java_competition_management_system.entity.User;
import cms.java_competition_management_system.mapper.UserMapper;
import cms.java_competition_management_system.service.UserService;
import cms.java_competition_management_system.utils.JwtUtil;
import cms.java_competition_management_system.utils.RedisCache;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private UserMapper userMapper;
    @Override
    public String login(LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(loginDTO.getStuId(), loginDTO.getPassword());
        Authentication authenticate = null;
                try {
                    authenticate = authenticationManager.authenticate(authentication);
                }catch (AuthenticationException e){
                    return "用户名或密码错误！";
                }
        User user = (User)authenticate.getPrincipal();
        if(user == null){
            return "用户名或密码错误！";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("id",user.getUserId());
        map.put("userName",user.getUsername());
        map.put("stuId",user.getStuId());
        map.put("avatar",user.getAvatar());
        map.put("perms",user.getPerms());
        redisCache.setCacheObject("login:"+user.getUserId(),map);
        return jwtUtil.createToken(map);
    }

    @Override
    public void logout() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            User userDetails = (User) principal;
            System.out.println("getUserId是："+userDetails.getUserId());
            redisCache.deleteObject("login:"+userDetails.getUserId());
        } else {
            Authentication authentication = (Authentication) principal;
            Object details = authentication.getDetails();
            if (details instanceof UserDetails) {
                User userDetails = (User) details;
                System.out.println("getUserId是："+userDetails.getUserId());
                redisCache.deleteObject("login:"+userDetails.getUserId());
            }
        }

    }

    @Override
    public List getRole(String token) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDetails = (User) principal;
        User user = userMapper.selectUserById(userDetails.getUserId());
        Set<Role> roleSet = user.getRoleSet();
        List newList = new ArrayList();
        for (Role role : roleSet) {
            newList.add(role.getRoleId());
        }
        return newList;
    }

    @Override
    public UserDeatilOutDTO getUserDetail() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDetails = (User) principal;
        UserDeatilOutDTO user = userMapper.selectUserDetail(userDetails.getUserId());
        return user;
    }

    @Override
    public void updataUserAvatar(String fileName) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDetails = (User) principal;
        userMapper.updataUserAvatar(userDetails.getUserId(),fileName);
    }

    @Override
    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }


}

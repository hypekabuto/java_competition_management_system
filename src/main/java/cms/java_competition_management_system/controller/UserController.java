package cms.java_competition_management_system.controller;

import cms.java_competition_management_system.common.ResponseResult;
import cms.java_competition_management_system.entity.InDTO.LoginDTO;
import cms.java_competition_management_system.entity.Role;
import cms.java_competition_management_system.entity.User;
import cms.java_competition_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("login")
    public ResponseResult login(@RequestBody LoginDTO loginDTO){
        if (userService.login(loginDTO).equals("用户名或密码错误！")){
            return new ResponseResult(401,"用户名或密码错误!");
        }else {
            return new ResponseResult(200,"登陆成功!",userService.login(loginDTO));
        }
    }
    @GetMapping("logout")
    public ResponseResult logout(){
        userService.logout();
        return new ResponseResult(200,"退出成功!");
    }
    @GetMapping("getRole")
    @PreAuthorize("hasAuthority('userCenter')")
    public ResponseResult getRole(@RequestHeader("Authorization") String token){
        System.out.println(token);
        List user = userService.getRole(token);
        return new ResponseResult(200,"用户初始化成功",user);
    }

}

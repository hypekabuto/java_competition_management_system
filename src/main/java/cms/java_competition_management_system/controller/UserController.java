package cms.java_competition_management_system.controller;

import cms.java_competition_management_system.common.ResponseResult;
import cms.java_competition_management_system.entity.InDTO.LoginDTO;
import cms.java_competition_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("login")
    public ResponseResult login(@RequestBody LoginDTO loginDTO){
        String token = userService.login(loginDTO);
        return new ResponseResult(200,"登陆成功!",token);
    }
    @GetMapping("logout")
    public ResponseResult logout(){
        userService.logout();
        return new ResponseResult(200,"退出成功!");
    }
}

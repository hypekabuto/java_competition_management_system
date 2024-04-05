package cms.java_competition_management_system.controller;

import cms.java_competition_management_system.common.ResponseResult;
import cms.java_competition_management_system.entity.InDTO.LoginDTO;
import cms.java_competition_management_system.entity.OutDTO.UserDeatilOutDTO;
import cms.java_competition_management_system.entity.Role;
import cms.java_competition_management_system.entity.User;
import cms.java_competition_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

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
        List user = userService.getRole(token);
        return new ResponseResult(200,"用户初始化成功",user);
    }
    @GetMapping("getUserDetail")
    @PreAuthorize("hasAuthority('userCenter')")
    public ResponseResult getUserDetail(){
        UserDeatilOutDTO userDetail = userService.getUserDetail();
        return new ResponseResult(200,"用户信息查询结果",userDetail);
    }
    @PostMapping("/uploadAvatar")
    @PreAuthorize("hasAuthority('userCenter')")
    public ResponseResult uploadAvatar(@RequestParam MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID() + suffix;
        userService.updataUserAvatar(fileName);
        String dirPath = "D:\\study\\毕业项目\\competition_information_management_system\\src\\assets\\images\\userAvatar";
        File dirFile = new File(dirPath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        String filePath = dirPath + "/" + fileName;
        System.out.println(filePath);
        file.transferTo(new File(filePath));
        return new ResponseResult(200,"头像上传成功",fileName);
    }
    @PostMapping("updateUserMessage")
    @PreAuthorize("hasAuthority('userCenter')")
    public ResponseResult updateUserMessage(@RequestBody User user){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDetails = (User) principal;
        user.setUserId(userDetails.getUserId());
        userService.updateUserById(user);
        System.out.println(user);
        return new ResponseResult(200,"修改成功!");
    }
}

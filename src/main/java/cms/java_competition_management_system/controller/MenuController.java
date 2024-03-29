package cms.java_competition_management_system.controller;

import cms.java_competition_management_system.common.ResponseResult;
import cms.java_competition_management_system.entity.Role;
import cms.java_competition_management_system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("menu")
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;
    @PostMapping("getMenuData")
    @PreAuthorize("hasAuthority('userCenter')")
    public ResponseResult getMenuData(@RequestBody List<Role> roleIdLists){
        List<Map<String,Object>> stringObjectMap = menuService.selectMenuData(roleIdLists);
        return new ResponseResult(200,"用户视窗地址",stringObjectMap);
    }
}

package cms.java_competition_management_system.service.Impl;

import cms.java_competition_management_system.entity.Menu;
import cms.java_competition_management_system.entity.Role;
import cms.java_competition_management_system.mapper.MenuMapper;
import cms.java_competition_management_system.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Map<String,Object>> selectMenuData(List<Role> roleIdLists) {
        List<Map<String,Object>> maps = new ArrayList<>();
        System.out.println(roleIdLists.get(0).getRoleId());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= roleIdLists.size()-1; i++){
            list.add(roleIdLists.get(i).getRoleId());
            Integer roleId = roleIdLists.get(i).getRoleId();
            List<Menu> roleList = menuMapper.selectMenuData(roleId);
            for (int y = 0; y <= roleList.size()-1; y++) {
                Map<String,Object> news = new HashMap<>();
                news.put("path","/" + roleList.get(y).getPerms());
                news.put("name",roleList.get(y).getPerms());
                news.put("label",roleList.get(y).getMenuName());
                news.put("icon",roleList.get(y).getIcon());
                news.put("url","/" + roleList.get(y).getPerms());
                maps.add(news);
            }
        }
        return maps;
    }
}

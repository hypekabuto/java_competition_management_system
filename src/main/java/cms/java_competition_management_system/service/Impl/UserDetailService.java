package cms.java_competition_management_system.service.Impl;

import cms.java_competition_management_system.entity.Menu;
import cms.java_competition_management_system.entity.Role;
import cms.java_competition_management_system.entity.User;
import cms.java_competition_management_system.mapper.MenuMapper;
import cms.java_competition_management_system.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public UserDetails loadUserByUsername(String stuId) throws UsernameNotFoundException {
        User user = userMapper.selectByStuId(stuId);
        if(user != null){
            Set<Role> roleSet = user.getRoleSet();
            Set<Integer> roleIds = new HashSet<>(roleSet.size());
            List<String> perms1 = user.getPerms();
            for (Role roleList : roleSet){
                roleIds.add(roleList.getRoleId());
            }
            Set<Menu> menus = menuMapper.selectMenuByRoleId(roleIds);
            for (Menu menu : menus) {
                String perms = menu.getPerms();
                perms1.add(perms);
            }
        }
        return user;
    }
}

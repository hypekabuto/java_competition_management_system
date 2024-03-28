package cms.java_competition_management_system.service.Impl;

import cms.java_competition_management_system.entity.Role;
import cms.java_competition_management_system.entity.User;
import cms.java_competition_management_system.mapper.RoleMapper;
import cms.java_competition_management_system.mapper.UserMapper;
import cms.java_competition_management_system.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}

package cms.java_competition_management_system.service;

import cms.java_competition_management_system.entity.InDTO.LoginDTO;
import cms.java_competition_management_system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<User> {
    String login(LoginDTO loginDTO);

    void logout();
    List getRole(String token);

}

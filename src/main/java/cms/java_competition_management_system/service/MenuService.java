package cms.java_competition_management_system.service;

import cms.java_competition_management_system.entity.Menu;
import cms.java_competition_management_system.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface MenuService extends IService<Menu> {
    List<Map<String,Object>> selectMenuData(List<Role> roleIdLists);
}

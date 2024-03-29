package cms.java_competition_management_system.mapper;

import cms.java_competition_management_system.entity.Menu;
import cms.java_competition_management_system.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    Set<Menu> selectMenuByRoleId(@Param("roleIds") Set<Integer> roleIds);
    List<Menu> selectMenuData(@Param("menuId")Integer menuId);
}

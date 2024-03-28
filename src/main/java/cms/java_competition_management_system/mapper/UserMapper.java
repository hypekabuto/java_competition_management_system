package cms.java_competition_management_system.mapper;

import cms.java_competition_management_system.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectByStuId(@Param("stuId") String stuId);
}

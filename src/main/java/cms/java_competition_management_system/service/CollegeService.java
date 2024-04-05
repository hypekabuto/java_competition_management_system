package cms.java_competition_management_system.service;

import cms.java_competition_management_system.entity.College;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CollegeService extends IService<College> {
    List<College> selectCollegeList();
}

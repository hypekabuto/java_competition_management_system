package cms.java_competition_management_system.service.Impl;

import cms.java_competition_management_system.entity.College;
import cms.java_competition_management_system.mapper.CollegeMapper;
import cms.java_competition_management_system.service.CollegeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;
    @Override
    public List<College> selectCollegeList() {
        List<College> colleges = collegeMapper.selectList(null);
        return colleges;
    }
}

package cms.java_competition_management_system.service.Impl;

import cms.java_competition_management_system.entity.Profession;
import cms.java_competition_management_system.mapper.ProfessionMapper;
import cms.java_competition_management_system.service.ProfessionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionServiceImpl  extends ServiceImpl<ProfessionMapper, Profession> implements ProfessionService {
    @Autowired
    private ProfessionMapper professionMapper;
    @Override
    public List<Profession> selectProfessionList() {
        List<Profession> professions = professionMapper.selectList(null);
        return professions;
    }
}

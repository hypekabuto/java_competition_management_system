package cms.java_competition_management_system.service;

import cms.java_competition_management_system.entity.Profession;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessionService extends IService<Profession> {
    List<Profession> selectProfessionList();
}

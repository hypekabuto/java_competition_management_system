package cms.java_competition_management_system.service;

import cms.java_competition_management_system.entity.Competition;
import cms.java_competition_management_system.entity.InDTO.SelectCompetitionListInDTO;
import cms.java_competition_management_system.entity.OutDTO.DictionaryOutDTO;
import cms.java_competition_management_system.entity.OutDTO.SelectCompetitionListOutDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.List;
import java.util.Map;

@Service
public interface CompetitionService extends IService<Competition> {
    Map<String,Object> selectCompetitionList(SelectCompetitionListInDTO competition);

    List<DictionaryOutDTO> selectDictionaryList(String codeType);
}

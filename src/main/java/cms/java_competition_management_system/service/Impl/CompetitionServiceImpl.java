package cms.java_competition_management_system.service.Impl;

import cms.java_competition_management_system.entity.College;
import cms.java_competition_management_system.entity.Competition;
import cms.java_competition_management_system.entity.InDTO.SelectCompetitionListInDTO;
import cms.java_competition_management_system.entity.OutDTO.DictionaryOutDTO;
import cms.java_competition_management_system.entity.OutDTO.SelectCompetitionListOutDTO;
import cms.java_competition_management_system.mapper.CollegeMapper;
import cms.java_competition_management_system.mapper.CompetitionMapper;
import cms.java_competition_management_system.service.CollegeService;
import cms.java_competition_management_system.service.CompetitionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompetitionServiceImpl extends ServiceImpl<CompetitionMapper, Competition> implements CompetitionService {
    @Autowired
    private CompetitionMapper competitionMapper;
    @Override
    public Map<String,Object> selectCompetitionList(SelectCompetitionListInDTO competition) {
        competition.calculateCurrentOffset();
        List<SelectCompetitionListOutDTO> competitions = competitionMapper.selectCompetitionList(competition);
        Integer total = competitionMapper.selectTotal(competition);
        Map<String,Object> finallyList = new HashMap<>();
        finallyList.put("total",total);
        finallyList.put("competitions",competitions);
        return finallyList;
    }

    @Override
    public List<DictionaryOutDTO> selectDictionaryList(String codeType) {
        List<DictionaryOutDTO> dictionaryList = competitionMapper.selectDictionaryList(codeType);
        return dictionaryList;
    }
}

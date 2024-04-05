package cms.java_competition_management_system.mapper;

import cms.java_competition_management_system.entity.Competition;
import cms.java_competition_management_system.entity.InDTO.SelectCompetitionListInDTO;
import cms.java_competition_management_system.entity.OutDTO.DictionaryOutDTO;
import cms.java_competition_management_system.entity.OutDTO.SelectCompetitionListOutDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Dictionary;
import java.util.List;

@Mapper
public interface CompetitionMapper extends BaseMapper<Competition> {
    List<SelectCompetitionListOutDTO> selectCompetitionList(@Param("competition") SelectCompetitionListInDTO competition);

    List<DictionaryOutDTO> selectDictionaryList(String codeType);

    Integer selectTotal(@Param("competition") SelectCompetitionListInDTO competition);
}

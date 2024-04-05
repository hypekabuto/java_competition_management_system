package cms.java_competition_management_system.controller;

import cms.java_competition_management_system.common.ResponseResult;
import cms.java_competition_management_system.entity.Competition;
import cms.java_competition_management_system.entity.InDTO.SelectCompetitionListInDTO;
import cms.java_competition_management_system.entity.OutDTO.DictionaryOutDTO;
import cms.java_competition_management_system.entity.OutDTO.SelectCompetitionListOutDTO;
import cms.java_competition_management_system.service.CollegeService;
import cms.java_competition_management_system.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Dictionary;
import java.util.List;
import java.util.Map;

@RequestMapping("competition")
@RestController
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService;
    @PostMapping("selectCompetitionList")
    @PreAuthorize("hasAuthority('competitionList')")
    public ResponseResult selectCompetitionList(@RequestBody SelectCompetitionListInDTO competition){
        Map<String,Object> competitionList = competitionService.selectCompetitionList(competition);
        return new ResponseResult(200,competitionList);
    }
    @GetMapping("selectDictionaryList")
    @PreAuthorize("hasAuthority('competitionList')")
    public ResponseResult selectDictionaryList(@RequestParam("codeType")String codeType){
        List<DictionaryOutDTO> difficultyList = competitionService.selectDictionaryList(codeType);
        return new ResponseResult(200,difficultyList);
    }
}

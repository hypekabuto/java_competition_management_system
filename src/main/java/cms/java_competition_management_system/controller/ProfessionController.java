package cms.java_competition_management_system.controller;

import cms.java_competition_management_system.common.ResponseResult;
import cms.java_competition_management_system.entity.College;
import cms.java_competition_management_system.entity.Profession;
import cms.java_competition_management_system.service.CollegeService;
import cms.java_competition_management_system.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("profession")
@RestController
public class ProfessionController {
    @Autowired
    private ProfessionService professionService;
    @GetMapping("getProfessionList")
    @PreAuthorize("hasAuthority('userCenter')")
    public ResponseResult getProfessionList(){
        List<Profession> professions = professionService.selectProfessionList();
        return new  ResponseResult(200,professions);
    }
}

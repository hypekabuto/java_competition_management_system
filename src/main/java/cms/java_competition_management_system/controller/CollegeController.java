package cms.java_competition_management_system.controller;

import cms.java_competition_management_system.common.ResponseResult;
import cms.java_competition_management_system.entity.College;
import cms.java_competition_management_system.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("college")
@RestController
public class CollegeController {
    @Autowired
    private CollegeService collegeService;
    @GetMapping("getCollegeList")
    @PreAuthorize("hasAuthority('userCenter')")
    public ResponseResult getCollegeList(){
        List<College> college = collegeService.selectCollegeList();
        return new  ResponseResult(200,college);
    }
}

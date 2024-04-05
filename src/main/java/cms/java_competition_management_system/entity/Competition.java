package cms.java_competition_management_system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("competition")
public class Competition {
    @TableId
    private Integer competitionId;
    private String competitionName;
    private String collegeId;
    private String competitionImage;
    private String difficulty;
    private String level;
    private String stage;
    private String competitionTime;
    private String createTime;
    private String creator;
    private String judgeStatus;
    private String judgement;
    private Integer deleted;
}

package cms.java_competition_management_system.entity.OutDTO;

import lombok.Data;

@Data
public class SelectCompetitionListOutDTO {
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
    private Integer total;
}

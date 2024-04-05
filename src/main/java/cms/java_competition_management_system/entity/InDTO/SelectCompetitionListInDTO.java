package cms.java_competition_management_system.entity.InDTO;

import lombok.Data;

@Data
public class SelectCompetitionListInDTO {
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
    private Integer pageSize;
    private Integer currentPage;
    private Integer currentOffset;
    public void calculateCurrentOffset() {
        this.currentOffset = (this.currentPage - 1) * this.pageSize;
    }
}

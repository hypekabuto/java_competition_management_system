package cms.java_competition_management_system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("profession")
public class Profession {
    @TableId
    private Integer professionId;
    private String collegeId;
    private String professionName;
}

package cms.java_competition_management_system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class College {
    @TableId
    private String collegeId;
    private String collegeName;
}

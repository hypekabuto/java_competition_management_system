package cms.java_competition_management_system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("role")
public class Role {
    @TableId
    private Integer roleId;
    private String roleLabel;
    private String roleName;
    private Integer status;
    @TableLogic
    private Integer deleted;
    private LocalDateTime createTime;

}

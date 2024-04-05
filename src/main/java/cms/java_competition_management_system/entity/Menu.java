package cms.java_competition_management_system.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("menu")
public class Menu {
    private Integer id;
    private Integer parentId;
    private String menuName;
    private String icon;
    private Integer sort;
    private String perms;
    private Integer menuType;
    private Integer deleted;
    private LocalDateTime createTime;
}

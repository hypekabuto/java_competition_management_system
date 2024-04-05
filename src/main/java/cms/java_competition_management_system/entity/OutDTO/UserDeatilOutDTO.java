package cms.java_competition_management_system.entity.OutDTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDeatilOutDTO {
    private Integer userId;
    private String userName;
    private String nickName;
    private String stuId;
    private String avatar;
    private Integer age;
    private Integer sex;
    private String birthday;
    private String email;
    private String classes;
    private String hobby;
    private String address;
    private Integer status;
}

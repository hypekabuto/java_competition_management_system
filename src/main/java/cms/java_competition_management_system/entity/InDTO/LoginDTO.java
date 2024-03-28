package cms.java_competition_management_system.entity.InDTO;

import lombok.Data;
import java.io.Serializable;

@Data
public class LoginDTO implements Serializable {
    private String stuId;
    private String password;
    private String code;
}

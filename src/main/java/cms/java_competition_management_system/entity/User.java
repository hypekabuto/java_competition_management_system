package cms.java_competition_management_system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Data
@TableName("user")
public class User implements Serializable, UserDetails {
    @TableId
    @TableField("user_id")
    private Integer userId;
    private String userName;
    private String nickName;
    private String stuId;
    private String password;
    private String avatar;
    private Integer age;
    private Integer sex;
    private String birthday;
    private String email;
    private String classes;
    private String hobby;
    private String address;
    private String college;
    private String profession;
    private Integer status;
    private String createTime;
    private String creator;
    private Integer deleted;
    @TableField(exist = false)
    private Set<Role> roleSet = new HashSet<>();
    @TableField(exist = false)
    private List<String> perms = new ArrayList<>();
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(perms != null && perms.size() > 0){
            return perms.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
        }
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return stuId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return status == 0;
    }

    @Override
    public boolean isAccountNonLocked() {
        return status == 0;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return status == 0;
    }

    @Override
    public boolean isEnabled() {
        return status == 0;
    }
}

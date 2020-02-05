package hxc.manage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
@Data
public class UserDetail implements Serializable {
    private Long id;
    private String name;
    private String gender;
    private String birthday;
    private String idCard;
    private String username;
    private String email;
    private String phone;
    private String address;
    private String department;
    private String workID;
    private Integer enable;
    private String user_id;
    private String password;
    private String tree;
    @JsonIgnore
    private Integer page;

}
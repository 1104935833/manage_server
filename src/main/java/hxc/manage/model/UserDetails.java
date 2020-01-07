package hxc.manage.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
@Data
public class UserDetails implements Serializable {
    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private String idCard;
    private String nation;
    private String username;
    private String email;
    private String phone;
    private String address;
    private String department;
    private String workID;
    private Integer enabled;
    private String user_id;
    private String password;
    private String tree;

}
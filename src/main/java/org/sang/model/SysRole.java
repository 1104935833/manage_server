package org.sang.model;

import java.util.Date;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/12 14:10
 */
public class SysRole {

    private Integer role_id;

    private String staff_type;

    private String role_name;

    private String role_desc;

    private Date update_time;

    private String update_staff_id;

    private String status;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getStaff_type() {
        return staff_type;
    }

    public void setStaff_type(String staff_type) {
        this.staff_type = staff_type;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getUpdate_staff_id() {
        return update_staff_id;
    }

    public void setUpdate_staff_id(String update_staff_id) {
        this.update_staff_id = update_staff_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

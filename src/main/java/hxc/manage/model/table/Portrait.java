package hxc.manage.model.table;

import lombok.Data;

import java.io.Serializable;

@Data
public class Portrait implements Serializable {

    private Integer id;

    private String name;

    private String projectLeader;

    private String title;

    private String department;

    private String date;

    private String phone;

    private Double applyRental;

    private Integer fileId;

    private String projectUnit;

    private Integer type;

    private String createTime;
    private Integer tableId;
}















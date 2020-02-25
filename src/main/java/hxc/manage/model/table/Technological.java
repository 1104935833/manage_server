package hxc.manage.model.table;

import lombok.Data;

import java.io.Serializable;

@Data
public class Technological implements Serializable {

    private Integer id;

    private String name;

    private String declareUnit;

    private String planCategory;

    private String specialName;

    private String supportUnit;

    private String declareTime;

    private String organizationUnit;

    private String address;

    private String declareUnitName;

    private String head;

    private String phone;

    private String approvalDepartment;

    private String approvalTime;

    private Integer fileId;

    private String createTime;
    private Integer tableId;
}

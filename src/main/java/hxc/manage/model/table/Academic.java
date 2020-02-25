package hxc.manage.model.table;

import lombok.Data;

import java.io.Serializable;

@Data
public class Academic implements Serializable {

    private Integer id;

    private String name;

    private String teamPersonnel;

    private String direction;

    private String schoolPlace;

    private String address;

    private String headPhone;

    private String declareTime;

    private String competentDepartment;

    private String level;

    private Integer fileId;

    private String createTime;

    private Integer tableId;


}

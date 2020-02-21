package hxc.manage.model.table;

import lombok.Data;

import java.io.Serializable;

@Data
public class Academic implements Serializable {

    private Integer id;

    private String teamName;

    private String teamPersonnel;

    private String direction;

    private String schoolPlace;

    private String address;

    private String headPhone;

    private String declareTime;

    private String competentDepartment;

    private Integer level;

    private Integer fileId;




}

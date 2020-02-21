package hxc.manage.model.table;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductionUnion implements Serializable {

    private Integer id;

    private String unioName;

    private String unionEffectTime;

    private String technologyField;

    private String unionDirector;

    private String unitPlace;

    private String phone;

    private String standingBodyName;

    private String standingBodyAddress;

    private String approvalDepartment;

    private String approvalTime;

    private Integer fileId;
}

package hxc.manage.model.table;

import lombok.Data;

import java.io.Serializable;

@Data
public class Lab implements Serializable {

    private Integer id;

    private String name;

    private String labApprovalTime;

    private String supportSubject;

    private String declareStartTime;

    private String declareEndTime;

    private Integer totalPerson;

    private String head;

    private String labAddress;

    private String directionOne;

    private String directionTwo;

    private String directionThree;

    private String approvalDepartment;

    private String approvalTime;

    private Integer fileId;

    private String createTime;
    private Integer tableId;
}

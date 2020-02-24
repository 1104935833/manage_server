package hxc.manage.model.table;

import lombok.Data;

@Data
public class Competition {
    

    private Integer id;

    private String name;

    private String organizer;

    private Integer participatingNumber;

    private String competitionLeader;

    private String responsibleTeacher;

    private String phone;

    private String address;

    private String agencyAddress;

    private String approvalDepartment;

    private String approvalTime;

    private Integer grade;

    private Integer fileId;

    private String createTime;
    
}

package hxc.manage.model.table;

import lombok.Data;

import java.io.Serializable;

@Data
public class FirstSubject implements Serializable {

    private Integer id;

    private String supportSchool;

    private String name;

    private String contact;

    private String phone;

    private String declareSubjectName;

    private String subjectLeader;

    private String inceptName;

    private String inceptTime;

    private String subjectThirdEvaluation;

    private String approvalDepartment;

    private String approvalTime;

    private Integer fileId;

    private String createTime;
    private Integer tableId;
}

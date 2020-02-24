package hxc.manage.model.table;

import lombok.Data;

@Data
public class Course {

    private Integer id;

    private String name;

    private String professionalPlace;

    private String courseLeader;

    private String teacherMain;

    private String teacherProfessional;

    private String teacherCertificate;

    private String declareTime;

    private Integer courseCategory;

    private Integer grade;

    private Integer fileId;

    private String createTime;

}

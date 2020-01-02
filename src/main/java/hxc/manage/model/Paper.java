package hxc.manage.model;


import lombok.Data;

import java.io.Serializable;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/24 9:26
 */
@Data
public class Paper implements Serializable {
    private String teacherId;
    private String paperType;
    private String paperTitle;
    private String firstAuthorType;
    private String firstAuthor;
    private String correspondenceAuthor;
    private String time;
    private String publication;
    private String publicationType;
    private String paperCategory;
    private String paperCompany;
    private String paperSource;
    private String paperVolume;
    private String paperPage;
    private String paperSchool;
    private Integer paperTranslation;
    private String paperCn;
    private Integer paperLocal;
    private Integer paperEnterprise;
    private Integer paperHigh;
    private String science;
    private String paperGrade;
    private String paperA;
    private String publicationScope;
    private String paperIssue;
    private Integer paperWord;
    private String page;
    private String paperIssn;


}

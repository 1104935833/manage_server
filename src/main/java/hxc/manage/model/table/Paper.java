package hxc.manage.model.table;


import lombok.Data;

import java.io.Serializable;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/24 9:26
 */
@Data
public class Paper implements Serializable {

    private Integer id;

    private String paperTitle;

    private String firstAuthor;

    private String correspondenceAuthor;

    private Integer firstAuthorType;

    private String publication;

    private String time;

    private String paperSchool;

    private Integer paperVolume;

    private String paperPage;

    private Integer paperGrade;

}

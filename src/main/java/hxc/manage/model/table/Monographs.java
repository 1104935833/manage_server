package hxc.manage.model.table;

import lombok.Data;

import java.io.Serializable;

@Data
public class Monographs implements Serializable {

    private Integer id;

    private String name;

    private String themeWord;

    private String authorName;

    private String finishTime;

    private String subordinateSubject;

    private String phone;

    private Integer wordNumber;

    private Integer publishedNumber;

    private Integer fileId;

    private String createTime;

}

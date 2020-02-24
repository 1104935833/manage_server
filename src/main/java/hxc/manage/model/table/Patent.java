package hxc.manage.model.table;

import lombok.Data;

import java.io.Serializable;

@Data
public class Patent implements Serializable {

    private Integer id;

    private String name;

    private Integer patentCategory;

    private String completer;

    private String patentNumber;

    private String signOorder;

    private String unitName;

    private String unitAddress;

    private Integer fileId;

    private String createTime;

}

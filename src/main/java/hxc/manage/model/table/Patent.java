package hxc.manage.model.table;

import lombok.Data;

import java.io.Serializable;

@Data
public class Patent implements Serializable {

    private Integer id;

    private String name;

    private String patentCategory;

    private String completer;

    private String patentNumber;

    private String signOrder;

    private String unitName;

    private String unitAddress;

    private Integer fileId;

    private String createTime;
    private Integer tableId;
}


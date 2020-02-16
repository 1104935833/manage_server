package hxc.manage.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Table implements Serializable {

    private Integer id;

    private Integer userId;

    private String tableId;

    private Integer state;

}

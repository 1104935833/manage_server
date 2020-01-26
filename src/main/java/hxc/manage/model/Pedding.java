package hxc.manage.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Pedding implements Serializable {

    private Integer id;

    private String type;

    private String role;

    private String main;

    private String name;

    private String tableId;

    private String state;

    private String url;

    private String operator;

    private String createTime;

    private String updateTime;


}

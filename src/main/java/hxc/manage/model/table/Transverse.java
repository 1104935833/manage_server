package hxc.manage.model.table;

import lombok.Data;

import java.io.Serializable;

@Data
public class Transverse implements Serializable {

    private Integer id;

    private String name;

    private String firstLevel;

    private String researchCategory;

    private String startTime;

    private String clientName;

    private String clientAddress;

    private String contractNature;

    private String projectLeader;

    private String level;

    private Integer fileId;

    private String createTime;

    private Integer tableId;
}

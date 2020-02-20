package hxc.manage.model.table;

import lombok.Data;

import java.io.Serializable;

@Data
public class Transverse implements Serializable {

    private Integer id;

    private String projectName;

    private String firstLevel;

    private Integer researchCategory;

    private String startTime;

    private String clientName;

    private String clientAddress;

    private Integer contractNature;

    private String projectLeader;

    private Integer level;

    private Integer fileId;
}

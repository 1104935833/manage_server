package hxc.manage.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Audit implements Serializable {

    private Integer id;

    private Integer proposerId;

    private Integer proposerType;

    private String proposerTime;

    private Integer auditorResearchId;

    private String auditorResearchTime;

    private Integer auditStatus;

    private Integer tableId;

    private Integer auditorCourtId;

    private String audtiorCourtTime;

}

package hxc.manage.model.table;

import lombok.Data;

import java.io.Serializable;

@Data
public class PatentInvent implements Serializable {

    private Integer id;

    private String inventName;

    private String inventor;

    private String phone;

    private String inventAddress;

    private String applicant;

    private String agent;

    private String applicationNumber;

    private String applicantAddress;

    private String agencyName;

    private String agencyAddress;

    private String agencyCode;

    private String patentNumber;

    private String softwareFullName;

    private String softwareShortName;

    private String versionNumber;

    private String startTime;

    private String finishTime;

    private String programmingLanguage;

    private String programAmount;

    private String hardwareEnvironment;

    private String softwareEnvironment;

    private String projectName;

    private String inventionUnit;

    private String projectLeader;

    private String acceptingUniName;

    private String acceptingUnitRepresentative;

    private String acceptingUnitPhone;

    private String acceptingUnitAddress;

    private String fileId;

    private Integer type;
}

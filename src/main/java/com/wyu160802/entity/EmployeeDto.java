package com.wyu160802.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 黄明潘
 * @date 2019/10/7-16:50
 */
@Data
public class EmployeeDto implements Serializable {

    private Integer id;
    private Integer deptId;
    private String deptName;
    private Integer jobId;
    private String jobName;
    private Integer sex;
    private String gender;
    private String name;
    private String cardId;
    private String address;
    private String postCode;
    private String phone;
    private String qqNum;
    private String email;
    private String party;
    private String race;
    private String education;
    private String speciality;
    private String hobby;
    private String remark;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String birthday;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createDate;

}

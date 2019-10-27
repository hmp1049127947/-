package com.wyu160802.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wyu160802.base.BaseEntity;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
@author 黄明潘
@date 2019/10/27-10:46
*/
@Getter
@Setter
@Component
public class Employee extends BaseEntity {
    private Integer id;

    private Integer deptId;

    private Integer jobId;

    private String name;

    private String cardId;

    private String address;

    private String postCode;

    private String phone;

    private String qqNum;

    private String email;

    private Integer sex;

    private String party;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String birthday;

    private String race;

    private String education;

    private String speciality;

    private String hobby;

    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createDate;
}
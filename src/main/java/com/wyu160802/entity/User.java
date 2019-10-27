package com.wyu160802.entity;

import com.wyu160802.base.BaseEntity;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
@author 黄明潘
@date 2019/10/27-11:27
*/
@Getter
@Setter
@Component
public class User extends BaseEntity {
    private Integer id;

    private String number;

    private String password;

    private Integer status;

    private String phone;

    private Date createdate;

    private String username;

    private String remark;
}
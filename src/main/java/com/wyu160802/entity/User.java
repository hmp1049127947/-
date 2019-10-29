package com.wyu160802.entity;

import com.wyu160802.base.BaseEntity;
import java.util.Date;

import com.wyu160802.utils.RegexpUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
@author 黄明潘
@date 2019/10/27-11:27
*/
@Getter
@Setter
@Component
public class User extends BaseEntity {
    private Integer id;

    @NotNull(message="账号不能为空")
    private String number;

    @Length(min = 6,max=10,message = "密码长度必须介于6-10位之间")
    private String password;

    private Integer status;

    @Pattern(regexp = RegexpUtils.PHONE,message = "手机号格式不正确")
    private String phone;
    
    private Date createdate;

    private String username;

    private String remark;
}
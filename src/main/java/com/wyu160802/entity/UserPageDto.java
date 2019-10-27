package com.wyu160802.entity;

import lombok.Data;

/**
 * @author 黄明潘
 * @date 2019/10/4-1:38
 */
@Data
public class UserPageDto {

    private String username;
    private String phone;
    private String number;
    private Integer pageNumber;
    private Integer rows;

}

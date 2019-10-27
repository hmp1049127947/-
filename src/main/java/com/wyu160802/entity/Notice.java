package com.wyu160802.entity;

import com.wyu160802.base.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
@author 黄明潘
@date 2019/10/27-11:24
*/
@Getter
@Setter
@Component
public class Notice extends BaseEntity {
    private Integer id;

    private String name;

    private String title;

    private String content;

    private String remark;
}
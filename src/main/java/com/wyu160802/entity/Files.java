package com.wyu160802.entity;

import com.wyu160802.base.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
@author 黄明潘
@date 2019/10/27-11:20
*/
@Getter
@Setter
@Component
public class Files extends BaseEntity {
    private Integer id;

    private String fileTitle;

    private String fileName;
}
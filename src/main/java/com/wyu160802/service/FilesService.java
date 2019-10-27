package com.wyu160802.service;

import com.wyu160802.base.BaseService;
import com.wyu160802.entity.Files;

import java.util.List;

/**
@author 黄明潘
@date 2019/10/27-11:20
*/
public interface FilesService extends BaseService<Files> {
    /**
     * 分页获取
     * @param page
     * @param rows
     * @return
     */
    List<Files> filesPage(Integer page, Integer rows);

    /**
     * 获取总条数
     * @return
     */
    int filesNum();
}

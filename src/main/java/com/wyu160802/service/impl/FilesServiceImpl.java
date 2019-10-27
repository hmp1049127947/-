package com.wyu160802.service.impl;

import com.wyu160802.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wyu160802.dao.FilesDao;
import com.wyu160802.entity.Files;
import com.wyu160802.service.FilesService;

import java.util.List;

/**
@author 黄明潘
@date 2019/10/27-11:20
*/
@Service
public class FilesServiceImpl extends BaseServiceImpl<Files,FilesDao> implements FilesService{

    @Override
    public List<Files> filesPage(Integer page, Integer rows) {
        return dao.filesPage(page,rows);
    }

    @Override
    public int filesNum() {
        return dao.filesNum();
    }
}

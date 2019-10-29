package com.wyu160802.dao;

import com.wyu160802.base.BaseDao;
import com.wyu160802.entity.Files;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
@author 黄明潘
@date 2019/10/27-11:20
*/
@Mapper
public interface FilesDao extends BaseDao<Files> {

}
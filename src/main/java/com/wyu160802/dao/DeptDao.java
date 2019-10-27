package com.wyu160802.dao;

import com.wyu160802.base.BaseDao;
import com.wyu160802.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
@author 黄明潘
@date 2019/10/27-1:01
*/
@Mapper
public interface DeptDao extends BaseDao<Dept> {

}
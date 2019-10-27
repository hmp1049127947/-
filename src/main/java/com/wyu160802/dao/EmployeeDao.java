package com.wyu160802.dao;

import com.wyu160802.base.BaseDao;
import com.wyu160802.entity.Employee;
import com.wyu160802.entity.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
@author 黄明潘
@date 2019/10/27-10:46
*/
@Mapper
public interface EmployeeDao extends BaseDao<Employee> {
    /**
     * 查询出处理后的数据
     * @return
     */
    List<EmployeeDto> queryEmpDto();

    /**
     * 通过id查询出处理后的数据
     * @param id
     * @return
     */
    EmployeeDto queryEmpDtoById(Integer id);
}
package com.wyu160802.service;

import com.wyu160802.base.BaseService;
import com.wyu160802.entity.Employee;
import com.wyu160802.entity.EmployeeDto;

import java.util.List;

/**
@author 黄明潘
@date 2019/10/27-10:46
*/
public interface EmployeeService extends BaseService<Employee> {
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

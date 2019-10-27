package com.wyu160802.service.impl;

import com.wyu160802.base.BaseServiceImpl;
import com.wyu160802.entity.EmployeeDto;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wyu160802.dao.EmployeeDao;
import com.wyu160802.entity.Employee;
import com.wyu160802.service.EmployeeService;

import java.util.List;

/**
@author 黄明潘
@date 2019/10/27-10:46
*/
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee,EmployeeDao> implements EmployeeService{

    @Override
    public List<EmployeeDto> queryEmpDto() {
        return dao.queryEmpDto();
    }

    @Override
    public EmployeeDto queryEmpDtoById(Integer id) {
        return dao.queryEmpDtoById(id);
    }
}

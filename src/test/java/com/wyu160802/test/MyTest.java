package com.wyu160802.test;

import com.wyu160802.entity.Dept;
import com.wyu160802.entity.Employee;
import com.wyu160802.service.DeptService;
import com.wyu160802.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/27-10:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml", "classpath:spring-druid.xml", "classpath:spring-mybatis.xml"})
public class MyTest {

    @Autowired
    private DeptService deptService;
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void deptServiceTest() {
        List<Dept> deptList = deptService.getAll();
        for (Dept dept : deptList) {
            System.out.println(dept.getId());
        }
    }

    @Test
    public void empTest() {
        List<Employee> employee = employeeService.getAll();
        for (Employee employee1 : employee) {
            System.out.println(employee1.getAddress());
        }
    }


}

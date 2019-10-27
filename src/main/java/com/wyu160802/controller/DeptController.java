package com.wyu160802.controller;

import com.alibaba.fastjson.JSON;
import com.wyu160802.base.BaseController;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.Dept;
import com.wyu160802.service.DeptService;
import com.wyu160802.utils.Constans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/6-13:24
 */
@Controller
@RequestMapping("dept")
public class DeptController extends BaseController<Dept,DeptService> {


    @PostMapping("del")
    @ResponseBody
    @Override
    public BaseResult delete(int id) {
        return  BaseResult.CrudMsg(service.deleteByPrimaryKey(id), "删除");
    }

    /**
     * 部门查询页面
     * @return
     */
    @GetMapping("queryDept")
    @Override
    public String page() {
        return "queryDept";
    }
}

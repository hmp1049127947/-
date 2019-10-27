package com.wyu160802.controller;

import com.alibaba.fastjson.JSON;
import com.wyu160802.base.BaseController;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.Job;
import com.wyu160802.service.JobService;
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
@RequestMapping("job")
public class JobController extends BaseController<Job,JobService> {

    @Override
    @PostMapping("del")
    @ResponseBody
    public BaseResult delete(int id) {
        return BaseResult.CrudMsg(service.deleteByPrimaryKey(id),"删除");
    }

    /**
     * 职业 页面
     * @return
     */
    @GetMapping("getJobPage")
    @Override
    public String page() {
        return "jobManage";
    }
}

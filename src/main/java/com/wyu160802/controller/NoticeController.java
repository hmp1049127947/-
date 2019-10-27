package com.wyu160802.controller;

import com.alibaba.fastjson.JSON;
import com.wyu160802.base.BaseController;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.Notice;
import com.wyu160802.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/4-20:01
 */
@Controller
@RequestMapping("/notice")
public class NoticeController extends BaseController<Notice,NoticeService> {


    /**
     * 公告添加页面
     * @return
     */
    @Override
    @GetMapping(value = "/addNotice")
    public String page() {
        return "addNotice";
    }
    /**
     * 公告查询页面
     * @return
     */
    @GetMapping("queryNotice")
    public String queryNotice() {
        return "queryNotice";
    }

    @GetMapping("/previews")
    public String showNotice(int id, Model model) {
        Notice notice = service.selectByPrimaryKey(id);
        model.addAttribute("notice", notice);
        return "showNotice";
    }

    @Override
    public BaseResult delete(int id) {
        return null;
    }

}

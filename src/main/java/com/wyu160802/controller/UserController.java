package com.wyu160802.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.dto.PageDto;
import com.wyu160802.dto.Pager;
import com.wyu160802.entity.User;
import com.wyu160802.entity.UserPageDto;
import com.wyu160802.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/9/23-19:13
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping(value = "/queryPerson")
    public String queryPerson(String keyword, Model model) {
        //查询所有用户
        if (StringUtils.isBlank(keyword)) {
            model.addAttribute("url", "/user/list");
        } else {
            model.addAttribute("keyword", keyword);
            model.addAttribute("url", "/user/search?keyword=" + keyword);
        }
        return "queryPerson";
    }

    @ResponseBody
    @GetMapping(value = "/list")
    public String list(int page,int rows) {
        Page<Object> startPage = PageHelper.startPage(page, rows);
        List<User> userList = userService.getAll();
        Pager<User> pager = new Pager<>();
        int total = (int) startPage.getTotal();
        pager.setTotal(total);
        pager.setRows(userList);
        return JSON.toJSONString(pager);
    }

    @ResponseBody
    @GetMapping(value = "search")
    public String search(int page,int rows,String keyword) {
        Page<Object> startPage = PageHelper.startPage(page, rows);
        List<User> users = userService.searchUser(keyword);
        Pager<User> pager = new Pager<>();
        int total = (int) startPage.getTotal();
        pager.setTotal(total);
        pager.setRows(users);
        return JSON.toJSONString(pager);
    }

    @ResponseBody
    @PostMapping(value = "delete", produces = "application/json; charset=utf-8")
    public String delUsers(String ids) {
        BaseResult baseResult;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            userService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }
        return JSON.toJSONString(baseResult);
    }

    /**
     * 用户编辑页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/editUser")
    public String editUser(int id,Model model) {
        System.out.println(id);
        User  user = userService.selectByPrimaryKey(id);
        model.addAttribute("user", user);
        return "editUser";
    }
    /**
     * 用户编辑处理
     * @param id
     * @param number
     * @param phone
     * @param username
     * @param password
     * @param remark
     * @return
     */
    @ResponseBody
    @PostMapping(value = "edit", produces = "application/json; charset=utf-8")
    public String editUser(int id,String number, String phone,
                           @RequestParam(required = false) String username, String password, @RequestParam(required = false) String remark) {
        User user = new User();
        user.setId(id);
        user.setNumber(number);
        user.setPhone(phone);
        user.setUsername(username);
        user.setPassword(password);
        user.setRemark(remark);
        System.out.println(user);
        BaseResult baseResult = userService.updateUser(user);
        System.out.println(baseResult.toString());
        return JSON.toJSONString(baseResult);
    }


    /**
     * 用户添加页面
     * @return
     */
    @GetMapping(value = "/addPerson")
    public String addPerson() {
        return "addPerson";
    }
    /**
     * 用户添加处理
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping(value = "add", produces = "application/json; charset=utf-8")
    public String insertPerson(User user) {
        System.out.println(user);
        BaseResult baseResult = userService.add(user);
        System.out.println(baseResult.toString());
        return JSON.toJSONString(baseResult);
    }

    @PostMapping(value = "valid", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String valid(String number,String phone) {
        BaseResult baseResult = null;
        if (number!=null&&phone==null) {
           User user = userService.queryByNumber(number);
            if (user != null) {
                baseResult = BaseResult.fail("该账号已被注册");
            }
        }
        if (phone!=null&&number==null) {
           User user = userService.queryByPhone(phone);
            if (user != null) {
                baseResult = BaseResult.fail("该手机号已被注册");
            }
        }
        return JSON.toJSONString(baseResult);
    }
}

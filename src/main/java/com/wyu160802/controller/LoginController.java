package com.wyu160802.controller;

import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.User;
import com.wyu160802.service.UserService;
import com.wyu160802.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 黄明潘
 * @date 2019/10/27-11:29
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "/login"})
    public String login(HttpServletRequest request) {
        String cookieValue = CookieUtils.getCookieValue(request, "remember_user",true);
        //如果cookie有值,cookie值里存的是账户号
        if (cookieValue != null) {
            //通过账号获取用户信息
            User user = userService.queryByNumber(cookieValue);
            if (user != null) {
                //登录成功
                request.getSession().setAttribute("user",user);
                return "redirect:/main";
            }
        }
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(String number,String password,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        Model model,
                        String remember) {

        //返回登录信息
        BaseResult baseResult = userService.login(number, password);
        System.out.println(baseResult);
        //登录成功
        if (baseResult.getStatus() == 200) {
            //获取保存在baseResult里的data
            User user = (User) baseResult.getData();
            //选中七天免登录
            if (remember != null) {
                //保存cookie
                CookieUtils.setCookie(request, response, "remember_user", user.getNumber(), 604800, true);
            }
            request.getSession().setAttribute("user", user);
            return "redirect:/main";

        } else {
            //登录失败
            model.addAttribute("baseResult", baseResult);
            return "login";
        }


    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        request.getSession().invalidate();
        CookieUtils.deleteCookie(request,response,"remember_user");
        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(User user, RedirectAttributes redirectAttributes) {
        //返回注册信息
        BaseResult baseResult = userService.add(user);
        if (baseResult.status == 200) {
            baseResult.setMessage("注册成功");
        }
        redirectAttributes.addFlashAttribute("baseResult", baseResult);
        return "redirect:/";
    }

}

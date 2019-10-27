package com.wyu160802.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 黄明潘
 * @date 2019/9/23-20:37
 */
@Controller
public class MainController {

    @GetMapping("/main")
    public String main() {
        return "main";
    }
}

package com.nkuvr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: weizujie
 * @Date: 2020/4/22
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/404")
    public String pageNotFound() {
        return "error/404";
    }

    @RequestMapping("/500")
    public String serverError() {
        return "error/500";
    }


}

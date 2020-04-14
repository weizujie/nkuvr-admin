package com.nkuvr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: weizujie
 * @Date: 2020/4/14
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

@Controller
@RequestMapping("/error")
public class ErrorController {
    @GetMapping("404")
    public String pageNotFound() {
        return "error/404";
    }

    @GetMapping("500")
    public String serverError() {
        return "error/500";
    }

    @GetMapping("unAuth")
    public String unAuthorized() {
        return "error/unAuth";
    }
}

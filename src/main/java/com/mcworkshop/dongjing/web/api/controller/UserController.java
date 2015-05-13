package com.mcworkshop.dongjing.web.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by markfredchen on 4/10/15.
 */
@Controller
public class UserController {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "Test";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hell() {
        return "Hello";
    }


}

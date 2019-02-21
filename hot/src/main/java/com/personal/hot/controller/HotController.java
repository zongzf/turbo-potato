package com.personal.hot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HotController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hellWorld(){
//        request.setAttribute("hello","Hello World!ert678");
        return "learning..";

    }

}

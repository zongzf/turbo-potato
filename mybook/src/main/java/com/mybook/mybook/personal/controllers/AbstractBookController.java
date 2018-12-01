package com.mybook.mybook.personal.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.mybook.mybook.personal.controllers.AbstractBookController.BASE_PATH;

@RequestMapping(BASE_PATH)
public abstract class AbstractBookController extends AbstractController {

    static final String BASE_PATH = "/demo" ;
}

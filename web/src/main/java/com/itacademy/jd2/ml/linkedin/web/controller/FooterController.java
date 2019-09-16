package com.itacademy.jd2.ml.linkedin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/footer")
public class FooterController {

    @RequestMapping(value = "/database", method = RequestMethod.GET)
    public ModelAndView findIndex() {

        return new ModelAndView("database");
    }

}

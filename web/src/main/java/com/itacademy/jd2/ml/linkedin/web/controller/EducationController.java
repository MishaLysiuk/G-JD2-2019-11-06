package com.itacademy.jd2.ml.linkedin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
@RequestMapping(value = "/education")
public class EducationController extends AbstractController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(Locale locale) {

        ModelAndView modelAndView = new ModelAndView("profile.education");

        return modelAndView;
    }

}

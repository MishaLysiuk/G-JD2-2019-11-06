package com.itacademy.jd2.ml.linkedin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
@RequestMapping(value = "/work-experience")
public class WorkExperienceController extends AbstractController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(Locale locale) {

        ModelAndView modelAndView = new ModelAndView("profile.work-experience");

        return modelAndView;
    }

}
package com.itacademy.jd2.ml.linkedin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
public class LoginController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(Locale locale, @RequestParam(value = "error", required = false) final String error,
                              @RequestParam(value = "logout", required = false) final String logout) {

        final ModelAndView model = new ModelAndView();
        model.setViewName("login");

        if (error != null) {
            model.addObject("error", messageSource.getMessage("page.login.credentialsError", new Object[] {}, locale));
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        return model;

    }
}
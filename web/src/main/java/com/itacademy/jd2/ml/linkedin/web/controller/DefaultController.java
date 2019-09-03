package com.itacademy.jd2.ml.linkedin.web.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class DefaultController {
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String  index(Locale locale) {
/*
        ModelAndView modelAndView = new ModelAndView("profile");

        String login = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();

        modelAndView.addObject("welcomeMessage",
                messageSource.getMessage("page.home.welcomeMessage", new Object[]{login}, locale));
        */
        return "redirect:/profile";
    }
}
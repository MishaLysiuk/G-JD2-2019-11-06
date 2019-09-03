package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.ICourseService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.impl.entity.Company;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.CourseToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.security.AuthHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping(value = "/course")
public class CourseController extends AbstractController{

    private ICourseService courseService;
    private CourseToDTOConverter toDTOConverter;

    @Autowired
    public CourseController(ICourseService courseService, CourseToDTOConverter toDTOConverter) {
        this.courseService = courseService;
        this.toDTOConverter = toDTOConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(Locale locale) {

        ModelAndView modelAndView = new ModelAndView("profile.course");

        ICourse course = courseService.findByUserId(AuthHelper.getLoggedUserId()).get(0);

        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("course", toDTOConverter.apply(course));
        hashMap.put("readOnly", true);

        return modelAndView;
    }

}

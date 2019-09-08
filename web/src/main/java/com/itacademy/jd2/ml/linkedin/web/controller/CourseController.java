package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.ICourseService;
import com.itacademy.jd2.ml.linkedin.IUserAccountService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.filter.CourseFilter;
import com.itacademy.jd2.ml.linkedin.web.converter.fromDTO.CourseFromDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.CourseToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.dto.CourseDTO;
import com.itacademy.jd2.ml.linkedin.web.security.AuthHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/course")
public class CourseController extends AbstractController{

    private IUserAccountService userAccountService;
    private ICourseService courseService;
    private CourseToDTOConverter toDTOConverter;
    private CourseFromDTOConverter fromDTOConverter;

    @Autowired
    public CourseController(IUserAccountService userAccountService, ICourseService courseService, CourseToDTOConverter toDTOConverter, CourseFromDTOConverter fromDTOConverter) {
        this.userAccountService = userAccountService;
        this.courseService = courseService;
        this.toDTOConverter = toDTOConverter;
        this.fromDTOConverter = fromDTOConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {

        IUserAccount loggedUser = userAccountService.getFullInfo(AuthHelper.getLoggedUserId());

        Set<ICourse> courses = loggedUser.getCourses();

        List<CourseDTO> coursesDTO = courses.stream().map(toDTOConverter).collect(Collectors.toList());

        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("course", coursesDTO);
        hashMap.put("readonly", true);

        return new ModelAndView("profile.course", hashMap);
    }

}

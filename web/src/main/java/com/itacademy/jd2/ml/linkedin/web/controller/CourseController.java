package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.ICompanyService;
import com.itacademy.jd2.ml.linkedin.ICourseService;
import com.itacademy.jd2.ml.linkedin.IUserAccountService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.filter.CourseFilter;
import com.itacademy.jd2.ml.linkedin.web.converter.fromDTO.CourseFromDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.CourseToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.dto.CourseDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.grid.GridStateDTO;
import com.itacademy.jd2.ml.linkedin.web.security.AuthHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/course")
public class CourseController extends AbstractController {

    private IUserAccountService userAccountService;
    private ICourseService courseService;
    private CourseToDTOConverter toDTOConverter;
    private CourseFromDTOConverter fromDTOConverter;

    private ICompanyService companyService;

    @Autowired
    public CourseController(IUserAccountService userAccountService, ICourseService courseService, CourseToDTOConverter toDTOConverter, CourseFromDTOConverter fromDTOConverter, ICompanyService companyService) {
        this.userAccountService = userAccountService;
        this.courseService = courseService;
        this.toDTOConverter = toDTOConverter;
        this.fromDTOConverter = fromDTOConverter;
        this.companyService = companyService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest req,
                              @RequestParam(name = "page", required = false) final Integer pageNumber) {

        final GridStateDTO gridState = getListDTO(req);
        gridState.setPage(pageNumber);

        final CourseFilter filter = new CourseFilter();
        prepareFilter(gridState, filter);

        IUserAccount loggedUser = userAccountService.getFullInfo(AuthHelper.getLoggedUserId());

        Set<ICourse> courses = loggedUser.getCourses();

        List<CourseDTO> coursesDTO = courses.stream().map(toDTOConverter).collect(Collectors.toList());

        gridState.setTotalCount(coursesDTO.size());

        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("courses", coursesDTO);
        return new ModelAndView("profile.course.list", hashMap);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showForm() {
        final ICourse newEntity = courseService.createEntity();
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("course", toDTOConverter.apply(newEntity));

        return new ModelAndView("profile.course.form", hashMap);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("Course") final CourseDTO courseDTO, @RequestParam("companyName") String companyName,
                       final BindingResult result) {
        if (result.hasErrors()) {
            return "profile.course.form";
        } else {
            ICourse entity = fromDTOConverter.apply(courseDTO);
            ICompany company = companyService.saveOrCreate(companyName);
            entity.setCompany(company);
            courseService.save(entity);
            IUserAccount loggedUser = userAccountService.getFullInfo(AuthHelper.getLoggedUserId());
            Set<ICourse> courses = loggedUser.getCourses();
            courses.add(entity);
            loggedUser.setCourses(courses);
            userAccountService.save(loggedUser);
            return "redirect:/course";
        }
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id", required = true) final Integer id) {
        courseService.delete(id);
        return "redirect:/course";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewDetails(
            @PathVariable(name = "id", required = true) final Integer id) {
        final ICourse course = courseService.getFullInfo(id);
        final CourseDTO dto = toDTOConverter.apply(course);
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("course", dto);
        hashMap.put("readonly", true);

        return new ModelAndView("profile.course.form", hashMap);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(
            @PathVariable(name = "id", required = true) final Integer id) {
        final ICourse course = courseService.getFullInfo(id);
        final CourseDTO dto = toDTOConverter.apply(course);
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("course", dto);
        hashMap.put("readonly", false);

        return new ModelAndView("profile.course.form", hashMap);
    }

}

package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.IDegreeService;
import com.itacademy.jd2.ml.linkedin.IEducationService;
import com.itacademy.jd2.ml.linkedin.ISpecialityService;
import com.itacademy.jd2.ml.linkedin.IUserAccountService;
import com.itacademy.jd2.ml.linkedin.entity.table.IDegree;
import com.itacademy.jd2.ml.linkedin.entity.table.IEducation;
import com.itacademy.jd2.ml.linkedin.entity.table.ISpeciality;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.filter.EducationFilter;
import com.itacademy.jd2.ml.linkedin.impl.EducationServiceImpl;
import com.itacademy.jd2.ml.linkedin.web.converter.fromDTO.EducationFromDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.EducationToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.dto.EducationDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.grid.GridStateDTO;
import com.itacademy.jd2.ml.linkedin.web.security.AuthHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/education")
public class EducationController extends AbstractController {

    private IUserAccountService userAccountService;
    private IEducationService educationService;
    private ISpecialityService specialityService;
    private IDegreeService degreeService;

    private EducationToDTOConverter toDTOConverter;
    private EducationFromDTOConverter fromDTOConverter;

    @Autowired
    public EducationController(IUserAccountService userAccountService, IEducationService educationService, ISpecialityService specialityService, IDegreeService degreeService, EducationToDTOConverter toDTOConverter, EducationFromDTOConverter fromDTOConverter) {
        this.userAccountService = userAccountService;
        this.educationService = educationService;
        this.specialityService = specialityService;
        this.degreeService = degreeService;
        this.toDTOConverter = toDTOConverter;
        this.fromDTOConverter = fromDTOConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest req,
                              @RequestParam(name = "page", required = false) final Integer pageNumber) {

        final GridStateDTO gridState = getListDTO(req);
        gridState.setPage(pageNumber);

        final EducationFilter filter = new EducationFilter();
        prepareFilter(gridState, filter);

        IUserAccount loggedUser = userAccountService.getFullInfo(AuthHelper.getLoggedUserId());

        Set<IEducation> educations = loggedUser.getEducations()
                .stream().map(iEducation -> educationService.getFullInfo(iEducation.getId())).collect(Collectors.toSet());

        List<EducationDTO> educationsDTO = educations.stream().map(toDTOConverter).collect(Collectors.toList());

        gridState.setTotalCount(educationsDTO.size());

        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("educations", educationsDTO);
        return new ModelAndView("profile.education.list", hashMap);
    }

    private void loadSpecialities(final Map<String, Object> hashMap) {

        final Map<Integer, String> specialities = specialityService.getAll().stream()
                .collect(Collectors.toMap(ISpeciality::getId, ISpeciality::getName));

        hashMap.put("specialities", specialities);

    }

    private void loadDegrees(final Map<String, Object> hashMap) {

        final Map<Integer, String> degrees = degreeService.getAll().stream()
                .collect(Collectors.toMap(IDegree::getId, IDegree::getName));

        hashMap.put("degrees", degrees);

    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showForm() {
        final IEducation newEntity = educationService.createEntity();
        final Map<String, Object> hashMap = new HashMap<>();
        loadSpecialities(hashMap);
        loadDegrees(hashMap);
        hashMap.put("education", toDTOConverter.apply(newEntity));

        return new ModelAndView("profile.education.form", hashMap);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("education") final EducationDTO educationDTO,
                       final BindingResult result) {
        if (result.hasErrors()) {
            return "profile.education.form";
        } else {
            IEducation entity = fromDTOConverter.apply(educationDTO);
            educationService.save(entity);
            IUserAccount loggedUser = userAccountService.getFullInfo(AuthHelper.getLoggedUserId());
            Set<IEducation> educations = loggedUser.getEducations();
            educations.add(entity);
            loggedUser.setEducations(educations);
            userAccountService.save(loggedUser);
            return "redirect:/education";
        }
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id", required = true) final Integer id) {
        educationService.delete(id);
        return "redirect:/education";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewDetails(
            @PathVariable(name = "id", required = true) final Integer id) {
        final IEducation education = educationService.getFullInfo(id);
        final EducationDTO dto = toDTOConverter.apply(education);
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("education", dto);
        hashMap.put("readonly", true);

        return new ModelAndView("profile.education.form", hashMap);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(
            @PathVariable(name = "id", required = true) final Integer id) {
        final IEducation education = educationService.getFullInfo(id);
        final EducationDTO dto = toDTOConverter.apply(education);
        final Map<String, Object> hashMap = new HashMap<>();
        loadSpecialities(hashMap);
        loadDegrees(hashMap);
        hashMap.put("education", dto);
        hashMap.put("readonly", false);

        return new ModelAndView("profile.education.form", hashMap);
    }

}

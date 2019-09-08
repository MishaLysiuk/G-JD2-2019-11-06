package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.IEducationService;
import com.itacademy.jd2.ml.linkedin.IUserAccountService;
import com.itacademy.jd2.ml.linkedin.entity.table.IEducation;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.web.converter.fromDTO.EducationFromDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.EducationToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.dto.EducationDTO;
import com.itacademy.jd2.ml.linkedin.web.security.AuthHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/education")
public class EducationController extends AbstractController {

    private IUserAccountService userAccountService;
    private IEducationService EducationService;
    private EducationToDTOConverter toDTOConverter;
    private EducationFromDTOConverter fromDTOConverter;

    @Autowired
    public EducationController(IUserAccountService userAccountService, IEducationService educationService, EducationToDTOConverter toDTOConverter, EducationFromDTOConverter fromDTOConverter) {
        this.userAccountService = userAccountService;
        EducationService = educationService;
        this.toDTOConverter = toDTOConverter;
        this.fromDTOConverter = fromDTOConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {

        IUserAccount loggedUser = userAccountService.getFullInfo(AuthHelper.getLoggedUserId());

        Set<IEducation> educations = loggedUser.getEducations();

        List<EducationDTO> educationsDTO = educations.stream().map(toDTOConverter).collect(Collectors.toList());

        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("education", educationsDTO);
        hashMap.put("readonly", true);

        return new ModelAndView("profile.education", hashMap);
    }

}

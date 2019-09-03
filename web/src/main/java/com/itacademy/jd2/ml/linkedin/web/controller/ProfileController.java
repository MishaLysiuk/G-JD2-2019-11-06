package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.IUserAccountService;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.web.converter.fromDTO.UserAccountFromDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.UserAccountToDTOConverter;
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
@RequestMapping(value = "/profile")
public class ProfileController extends AbstractController {

    private IUserAccountService userAccountService;
    private UserAccountFromDTOConverter fromDtoConverter;
    private UserAccountToDTOConverter toDtoConverter;

    @Autowired
    public ProfileController(IUserAccountService userAccountService, UserAccountFromDTOConverter fromDtoConverter, UserAccountToDTOConverter toDtoConverter) {
        this.userAccountService = userAccountService;
        this.fromDtoConverter = fromDtoConverter;
        this.toDtoConverter = toDtoConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(Locale locale) {

        IUserAccount loggedUser = userAccountService.get(AuthHelper.getLoggedUserId());
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("userAccountDTO", toDtoConverter.apply(loggedUser));
        hashMap.put("readonly", true);
        return new ModelAndView("profile", hashMap);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(Locale locale){

        IUserAccount loggedUser = userAccountService.get(AuthHelper.getLoggedUserId());
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("userAccountDTO", toDtoConverter.apply(loggedUser));
        hashMap.put("readonly", false);
        return new ModelAndView("profile", hashMap);

    }

}

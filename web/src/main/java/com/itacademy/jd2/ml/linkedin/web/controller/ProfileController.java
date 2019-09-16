package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.ILanguageService;
import com.itacademy.jd2.ml.linkedin.IUserAccountService;
import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.web.converter.fromDTO.UserAccountFromDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.UserAccountToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.dto.PasswordDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.UserAccountDTO;
import com.itacademy.jd2.ml.linkedin.web.security.AuthHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController extends AbstractController {

    private IUserAccountService userAccountService;
    private UserAccountFromDTOConverter fromDtoConverter;
    private UserAccountToDTOConverter toDtoConverter;
    private ILanguageService languageService;

    @Autowired
    public ProfileController(IUserAccountService userAccountService, UserAccountFromDTOConverter fromDtoConverter, UserAccountToDTOConverter toDtoConverter, ILanguageService languageService) {
        this.userAccountService = userAccountService;
        this.fromDtoConverter = fromDtoConverter;
        this.toDtoConverter = toDtoConverter;
        this.languageService = languageService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {

        IUserAccount loggedUser = userAccountService.getFullInfo(AuthHelper.getLoggedUserId());
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("userAccountDTO", toDtoConverter.apply(loggedUser));
        loadLanguages(hashMap);
        hashMap.put("readonly", true);
        return new ModelAndView("profile", hashMap);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit() {

        IUserAccount loggedUser = userAccountService.getFullInfo(AuthHelper.getLoggedUserId());
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("userAccountDTO", toDtoConverter.apply(loggedUser));
        loadLanguages(hashMap);
        hashMap.put("readonly", false);
        return new ModelAndView("profile", hashMap);
    }

    @RequestMapping(value = "/password", method = RequestMethod.GET)
    public ModelAndView changePassword() {

        Map<String, Object> hashMap = new HashMap<>();

        hashMap.put("passwordDTO", new PasswordDTO());

        return new ModelAndView("password", hashMap);
    }

    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public Object saveNewPassword(@Valid @ModelAttribute("passwordDTO") PasswordDTO passwordDTO, final BindingResult result) {

        if (result.hasErrors()) {
            return "profile.work-experience.form";
        } else {

            Map<String, Object> hashMap = new HashMap<>();

            IUserAccount loggedUser = userAccountService.get(AuthHelper.getLoggedUserId());

            String userPassword = loggedUser.getPassword();

            if (userAccountService.checkPassword(userPassword, passwordDTO.getOldPassword(), passwordDTO.getNewPassword(), passwordDTO.getConfirmPassword())) {
                loggedUser.setPassword(passwordDTO.getNewPassword());
                userAccountService.save(loggedUser);
                return "redirect:/profile";
            } else {
                hashMap.put("error", "Invalid password");
                return new ModelAndView("password", hashMap);
            }
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object save(@Valid @ModelAttribute("userAccountDTO") final UserAccountDTO loggedUser,
                       final BindingResult result) {
        if (result.hasErrors()) {
            final Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("userAccountDTO", loggedUser);
            loadLanguages(hashMap);
            hashMap.put("readonly", false);
            return new ModelAndView("profile", hashMap);
        } else {
            final IUserAccount entity = fromDtoConverter.apply(loggedUser);
            userAccountService.save(entity);
            return "redirect:/profile";
        }
    }

    private void loadLanguages(final Map<String, Object> hashMap) {

        final Map<Integer, String> languagesTypesMap = languageService.getAll().stream()
                .collect(Collectors.toMap(ILanguage::getId, ILanguage::getName));

        hashMap.put("languagesChoices", languagesTypesMap);

    }

}

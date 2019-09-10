package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.ILanguageLevelService;
import com.itacademy.jd2.ml.linkedin.ILanguageService;
import com.itacademy.jd2.ml.linkedin.IUserAccountService;
import com.itacademy.jd2.ml.linkedin.IUserLanguageService;
import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import com.itacademy.jd2.ml.linkedin.entity.table.ILanguageLevel;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserLanguage;
import com.itacademy.jd2.ml.linkedin.filter.UserLanguageFilter;
import com.itacademy.jd2.ml.linkedin.web.converter.fromDTO.UserLanguageFromDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.UserLanguageToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.dto.UserLanguageDTO;
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
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/language")
public class LanguageController extends AbstractController{

    private IUserLanguageService userLanguageService;
    private UserLanguageToDTOConverter toDTOConverter;
    private UserLanguageFromDTOConverter fromDTOConverter;

    private ILanguageService languageService;
    private ILanguageLevelService levelService;
    private IUserAccountService userAccountService;

    @Autowired
    public LanguageController(IUserLanguageService userLanguageService, UserLanguageToDTOConverter toDTOConverter, UserLanguageFromDTOConverter fromDTOConverter, ILanguageService languageService, ILanguageLevelService levelService, IUserAccountService userAccountService) {
        this.userLanguageService = userLanguageService;
        this.toDTOConverter = toDTOConverter;
        this.fromDTOConverter = fromDTOConverter;
        this.languageService = languageService;
        this.levelService = levelService;
        this.userAccountService = userAccountService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest req,
                              @RequestParam(name = "page", required = false) final Integer pageNumber) {

        final GridStateDTO gridState = getListDTO(req);
        gridState.setPage(pageNumber);

        final UserLanguageFilter filter = new UserLanguageFilter();
        prepareFilter(gridState, filter);

        List<IUserLanguage> languages = userLanguageService.findByUserId(AuthHelper.getLoggedUserId());

        List<UserLanguageDTO> userLanguagesDTO = languages.stream().map(toDTOConverter).collect(Collectors.toList());

        gridState.setTotalCount(userLanguagesDTO.size());

        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("userLanguages", userLanguagesDTO);
        return new ModelAndView("profile.language.list", hashMap);
    }

    private void loadLanguages(final Map<String, Object> hashMap) {

        final Map<Integer, String> languagesTypesMap = languageService.getAll().stream()
                .collect(Collectors.toMap(ILanguage::getId, ILanguage::getName));

        hashMap.put("languagesChoices", languagesTypesMap);

    }

    private void loadLevels(final Map<String, Object> hashMap) {

        final Map<Integer, String> levels = levelService.getAll().stream()
                .collect(Collectors.toMap(ILanguageLevel::getId, ILanguageLevel::getName));

        hashMap.put("levels", levels);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showForm() {
        final IUserLanguage newEntity = userLanguageService.createEntity();
        final Map<String, Object> hashMap = new HashMap<>();
        loadLanguages(hashMap);
        loadLevels(hashMap);
        hashMap.put("userLanguage", toDTOConverter.apply(newEntity));

        return new ModelAndView("profile.language.form", hashMap);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("userLanguage") final UserLanguageDTO userLanguageDTO,
                       final BindingResult result) {
        if (result.hasErrors()) {
            return "profile.language.form";
        } else {
            final IUserLanguage entity = fromDTOConverter.apply(userLanguageDTO);
            IUserAccount loggedUser = userAccountService.createEntity();
            loggedUser.setId(AuthHelper.getLoggedUserId());
            entity.setUser(loggedUser);
            userLanguageService.save(entity);
            return "redirect:/language";
        }
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id", required = true) final Integer id) {
        userLanguageService.delete(id);
        return "redirect:/UserLanguage";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewDetails(
            @PathVariable(name = "id", required = true) final Integer id) {
        final IUserLanguage language = userLanguageService.getFullInfo(id);
        final UserLanguageDTO dto = toDTOConverter.apply(language);
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("userLanguage", dto);
        hashMap.put("readonly", true);

        return new ModelAndView("profile.language.form", hashMap);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(
            @PathVariable(name = "id", required = true) final Integer id) {
        final IUserLanguage UserLanguage = userLanguageService.getFullInfo(id);
        final UserLanguageDTO dto = toDTOConverter.apply(UserLanguage);
        final Map<String, Object> hashMap = new HashMap<>();
        loadLanguages(hashMap);
        loadLevels(hashMap);
        hashMap.put("userLanguage", dto);
        hashMap.put("readonly", false);

        return new ModelAndView("profile.language.form", hashMap);
    }

}

package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.*;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.filter.CourseFilter;
import com.itacademy.jd2.ml.linkedin.filter.UserAccountFilter;
import com.itacademy.jd2.ml.linkedin.web.converter.fromDTO.UserAccountFromDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.*;
import com.itacademy.jd2.ml.linkedin.web.dto.CourseDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.JobTitleDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.UserAccountDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.grid.GridStateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value = "/worker")
public class UserAccountController extends AbstractController {

    private IUserAccountService userAccountService;
    private UserAccountToDTOConverter toDTOConverter;

    private ILanguageService languageService;

    @Autowired
    public UserAccountController(IUserAccountService userAccountService, UserAccountToDTOConverter toDTOConverter, ILanguageService languageService) {
        this.userAccountService = userAccountService;
        this.toDTOConverter = toDTOConverter;
        this.languageService = languageService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(final HttpServletRequest req,
                              @RequestParam(name = "page", required = false) final Integer pageNumber) {

        final GridStateDTO gridState = getListDTO(req);
        gridState.setPage(pageNumber);

        final UserAccountFilter filter = new UserAccountFilter();
        prepareFilter(gridState, filter);

        final List<IUserAccount> workers = userAccountService.find(filter);
        List<UserAccountDTO> workersDTO = workers.stream().map(toDTOConverter).collect(Collectors.toList());
        gridState.setTotalCount(userAccountService.getCount(filter));

        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("workers", workersDTO);
        return new ModelAndView("account.list", hashMap);
    }

    private void loadLanguages(final Map<String, Object> hashMap) {

        final Map<Integer, String> languagesTypesMap = languageService.getAll().stream()
                .collect(Collectors.toMap(ILanguage::getId, ILanguage::getName));

        hashMap.put("languagesChoices", languagesTypesMap);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewDetails(
            @PathVariable(name = "id", required = true) final Integer id) {
        final IUserAccount worker = userAccountService.getFullInfo(id);
        final UserAccountDTO workerDTO = toDTOConverter.apply(worker);
        final Map<String, Object> hashMap = new HashMap<>();
        loadLanguages(hashMap);
        hashMap.put("item", workerDTO);
        hashMap.put("readonly", true);

        return new ModelAndView("account.edit", hashMap);
    }

    @RequestMapping(value = "/byJobTitle", method = RequestMethod.GET)
    public ModelAndView findByJobTitle() {
        Map<String, Object> hashMap = new HashMap<>();

        hashMap.put("jobTitle", new JobTitleDTO());

        return new ModelAndView("account.findByJobTitle", hashMap);
    }

    @RequestMapping(value = "/byJobTitle", method = RequestMethod.POST)
    public ModelAndView findByJobTitleResults(HttpServletRequest req,
                                              @RequestParam(name = "page", required = false) final Integer pageNumber, @RequestParam(value = "jobTitle") String jobTitle) {

        final GridStateDTO gridState = getListDTO(req);
        gridState.setPage(pageNumber);

        final UserAccountFilter filter = new UserAccountFilter();
        prepareFilter(gridState, filter);

        Map<String, Object> hashMap = new HashMap<>();
        List<IUserAccount> workers = userAccountService.searchByJobTitle(jobTitle)
                .stream().map(worker -> userAccountService.getFullInfo(worker.getId())).collect(Collectors.toList());

        List<UserAccountDTO> workersDTO = workers.stream().map(toDTOConverter).collect(Collectors.toList());

        gridState.setTotalCount(workersDTO.size());

        hashMap.put("workers", workersDTO);
        return new ModelAndView("account.list", hashMap);
    }


}

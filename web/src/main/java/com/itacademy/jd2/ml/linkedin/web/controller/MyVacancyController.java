package com.itacademy.jd2.ml.linkedin.web.controller;


import com.itacademy.jd2.ml.linkedin.ICompanyService;
import com.itacademy.jd2.ml.linkedin.IUserAccountService;
import com.itacademy.jd2.ml.linkedin.IVacancyService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.entity.table.IVacancy;
import com.itacademy.jd2.ml.linkedin.filter.VacancyFilter;
import com.itacademy.jd2.ml.linkedin.web.converter.fromDTO.VacancyFromDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.VacancyToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.dto.VacancyDTO;
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
@RequestMapping(value = "/myvacancy")
public class MyVacancyController extends AbstractController {

    private IVacancyService vacancyService;
    private VacancyFromDTOConverter fromDTOConverter;
    private VacancyToDTOConverter toDTOConverter;
    
    private ICompanyService companyService;
    private IUserAccountService userAccountService;

    @Autowired
    public MyVacancyController(IVacancyService vacancyService, VacancyFromDTOConverter fromDTOConverter, VacancyToDTOConverter toDTOConverter, ICompanyService companyService, IUserAccountService userAccountService) {
        this.vacancyService = vacancyService;
        this.fromDTOConverter = fromDTOConverter;
        this.toDTOConverter = toDTOConverter;
        this.companyService = companyService;
        this.userAccountService = userAccountService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest req,
                              @RequestParam(name = "page", required = false) final Integer pageNumber) {

        final GridStateDTO gridState = getListDTO(req);
        gridState.setPage(pageNumber);

        final VacancyFilter filter = new VacancyFilter();
        prepareFilter(gridState, filter);

        List<IVacancy> vacancies = vacancyService.findByCreatorId(AuthHelper.getLoggedUserId());

        List<VacancyDTO> vacanciesDTO = vacancies.stream().map(toDTOConverter).collect(Collectors.toList());

        gridState.setTotalCount(vacanciesDTO.size());

        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("vacancies", vacanciesDTO);
        return new ModelAndView("myVacancy.list", hashMap);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showForm() {
        final Map<String, Object> hashMap = new HashMap<>();
        final IVacancy newEntity = vacancyService.createEntity();
        hashMap.put("formVacancy", toDTOConverter.apply(newEntity));

        return new ModelAndView("myVacancy.form", hashMap);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("Vacancy") final VacancyDTO vacancyDTO, @RequestParam("companyName") String companyName,
                       final BindingResult result) {
        if (result.hasErrors()) {
            return "myVacancy.form";
        } else {
            final IVacancy entity = fromDTOConverter.apply(vacancyDTO);
            ICompany company = companyService.saveOrCreate(companyName);
            entity.setCompany(company);
            IUserAccount loggedUser = userAccountService.createEntity();
            loggedUser.setId(AuthHelper.getLoggedUserId());
            entity.setCreator(loggedUser);
            vacancyService.save(entity);
            return "redirect:/myvacancy";
        }
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id", required = true) final Integer id) {
        vacancyService.delete(id);
        return "redirect:/myvacancy";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewDetails(
            @PathVariable(name = "id", required = true) final Integer id) {
        final IVacancy dbAccount = vacancyService.getFullInfo(id);
        final VacancyDTO dto = toDTOConverter.apply(dbAccount);


        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("formVacancy", dto);
        hashMap.put("readonly", true);

        return new ModelAndView("myVacancy.form", hashMap);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(
            @PathVariable(name = "id", required = true) final Integer id) {
        final IVacancy vacancy = vacancyService.getFullInfo(id);
        final VacancyDTO dto = toDTOConverter.apply(vacancy);
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("formVacancy", dto);
        hashMap.put("readonly", false);

        return new ModelAndView("myVacancy.form", hashMap);
    }

}

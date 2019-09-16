package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.ICompanyService;
import com.itacademy.jd2.ml.linkedin.IVacancyService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.IVacancy;
import com.itacademy.jd2.ml.linkedin.filter.VacancyFilter;
import com.itacademy.jd2.ml.linkedin.web.converter.fromDTO.VacancyFromDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.VacancyToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.dto.CompanyDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.JobTitleDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.LocationDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.VacancyDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.grid.GridStateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/findvacancy")
public class FindVacancyController extends AbstractController {

    private IVacancyService vacancyService;
    private VacancyFromDTOConverter fromDTOConverter;
    private VacancyToDTOConverter toDTOConverter;

    @Autowired
    public FindVacancyController(IVacancyService vacancyService, VacancyFromDTOConverter fromDTOConverter, VacancyToDTOConverter toDTOConverter) {
        this.vacancyService = vacancyService;
        this.fromDTOConverter = fromDTOConverter;
        this.toDTOConverter = toDTOConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findIndex(final HttpServletRequest req,
                                  @RequestParam(name = "page", required = false) final Integer pageNumber,
                                  @RequestParam(name = "sort", required = false) final String sortColumn) {

        final GridStateDTO gridState = getListDTO(req);
        gridState.setPage(pageNumber);
        gridState.setSort(sortColumn, "id");

        final VacancyFilter filter = new VacancyFilter();
        prepareFilter(gridState, filter);

        final List<IVacancy> entities = vacancyService.find(filter);
        List<VacancyDTO> dtos = entities.stream().map(toDTOConverter).collect(Collectors.toList());
        gridState.setTotalCount(vacancyService.getCount(filter));

        final Map<String, Object> models = new HashMap<>();
        models.put("gridItems", dtos);
        return new ModelAndView("findVacancy.list", models);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewDetails(
            @PathVariable(name = "id", required = true) final Integer id) {
        final IVacancy dbAccount = vacancyService.getFullInfo(id);
        final VacancyDTO dto = toDTOConverter.apply(dbAccount);
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("formVacancy", dto);
        hashMap.put("readonly", true);

        return new ModelAndView("findVacancy.form", hashMap);
    }

    @RequestMapping(value = "/byJobTitle", method = RequestMethod.GET)
    public ModelAndView findByJobTitle(){
        Map<String, Object> hashMap = new HashMap<>();

        hashMap.put("jobTitle", new JobTitleDTO());

        return new ModelAndView("findVacancy.byJobTitle", hashMap);
    }

    @RequestMapping(value = "/byJobTitle", method = RequestMethod.POST)
    public ModelAndView findByJobTitleResults(HttpServletRequest req,
                                      @RequestParam(name = "page", required = false) final Integer pageNumber, @RequestParam(value = "jobTitle") String jobTitle) {

        final GridStateDTO gridState = getListDTO(req);
        gridState.setPage(pageNumber);

        final VacancyFilter filter = new VacancyFilter();
        prepareFilter(gridState, filter);

        Map<String, Object> hashMap = new HashMap<>();
        List<IVacancy> vacancies = vacancyService.searchByJobTitle(jobTitle)
                .stream().map(iVacancy -> vacancyService.getFullInfo(iVacancy.getId())).collect(Collectors.toList());

        List<VacancyDTO> vacanciesDTO = vacancies.stream().map(toDTOConverter).collect(Collectors.toList());

        gridState.setTotalCount(vacanciesDTO.size());

        hashMap.put("vacancies", vacanciesDTO);
        hashMap.put("job", true);
        return new ModelAndView("findVacancy.list", hashMap);
    }

    @RequestMapping(value = "/byCity", method = RequestMethod.GET)
    public ModelAndView findByCity(){
        Map<String, Object> hashMap = new HashMap<>();

        hashMap.put("location", new LocationDTO());

        return new ModelAndView("findVacancy.byCity", hashMap);
    }

    @RequestMapping(value = "/byCity", method = RequestMethod.POST)
    public ModelAndView findByCityResults(HttpServletRequest req,
                                      @RequestParam(name = "page", required = false) final Integer pageNumber, @RequestParam(value = "cityId") Integer cityId) {

        final GridStateDTO gridState = getListDTO(req);
        gridState.setPage(pageNumber);

        final VacancyFilter filter = new VacancyFilter();
        prepareFilter(gridState, filter);

        Map<String, Object> hashMap = new HashMap<>();
        List<IVacancy> vacancies = vacancyService.findByCityId(cityId);


        List<VacancyDTO> vacanciesDTO = vacancies.stream().map(toDTOConverter).collect(Collectors.toList());

        gridState.setTotalCount(vacanciesDTO.size());

        hashMap.put("vacancies", vacanciesDTO);
        hashMap.put("city", true);
        return new ModelAndView("findVacancy.list", hashMap);
    }

    @RequestMapping(value = "/byCompany", method = RequestMethod.GET)
    public ModelAndView findByCompany(){
        Map<String, Object> hashMap = new HashMap<>();

        hashMap.put("company", new CompanyDTO());

        return new ModelAndView("findVacancy.byCompany", hashMap);
    }

    @RequestMapping(value = "/byCompany", method = RequestMethod.POST)
    public ModelAndView findByCompanyResults(HttpServletRequest req,
                                      @RequestParam(name = "page", required = false) final Integer pageNumber, @RequestParam("name")String companyName){

        final GridStateDTO gridState = getListDTO(req);
        gridState.setPage(pageNumber);

        final VacancyFilter filter = new VacancyFilter();
        prepareFilter(gridState, filter);

        Map<String, Object> hashMap = new HashMap<>();
        List<IVacancy> vacancies = vacancyService.findByCompany(companyName);


        List<VacancyDTO> vacanciesDTO = vacancies.stream().map(toDTOConverter).collect(Collectors.toList());

        gridState.setTotalCount(vacanciesDTO.size());

        hashMap.put("vacancies", vacanciesDTO);
        hashMap.put("company", true);
        return new ModelAndView("findVacancy.list", hashMap);
    }

}

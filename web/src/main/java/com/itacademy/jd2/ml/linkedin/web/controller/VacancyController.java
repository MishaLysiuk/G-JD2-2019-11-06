package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.IVacancyService;
import com.itacademy.jd2.ml.linkedin.entity.table.IVacancy;
import com.itacademy.jd2.ml.linkedin.filter.VacancyFilter;
import com.itacademy.jd2.ml.linkedin.web.converter.VacancyFromDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.VacancyToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.dto.VacancyDTO;
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
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/jobs")
public class VacancyController extends AbstractController {
    
    private IVacancyService vacancyService;
    private VacancyFromDTOConverter fromDtoConverter;
    private VacancyToDTOConverter toDtoConverter;

    @Autowired
    public VacancyController(IVacancyService vacancyService, VacancyFromDTOConverter fromDTOConverter, VacancyToDTOConverter toDTOConverter) {
        super();
        this.vacancyService = vacancyService;
        this.fromDtoConverter = fromDTOConverter;
        this.toDtoConverter = toDTOConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(final HttpServletRequest req,
                              @RequestParam(name = "page", required = false) final Integer pageNumber,
                              @RequestParam(name = "sort", required = false) final String sortColumn) {

        final GridStateDTO gridState = getListDTO(req);
        gridState.setPage(pageNumber);
        gridState.setSort(sortColumn, "id");

        final VacancyFilter filter = new VacancyFilter();
        prepareFilter(gridState, filter);

        final List<IVacancy> entities = vacancyService.find(filter);
        List<VacancyDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());
        gridState.setTotalCount(vacancyService.getCount(filter));

        final Map<String, Object> models = new HashMap<>();
        models.put("gridItems", dtos);
        return new ModelAndView("vacancy.list", models);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showForm() {
        final Map<String, Object> hashMap = new HashMap<>();
        final IVacancy newEntity = vacancyService.createEntity();
        hashMap.put("formVacancy", toDtoConverter.apply(newEntity));

        return new ModelAndView("vacancy.edit", hashMap);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("formVacancy") final VacancyDTO formAccount,
                       final BindingResult result) {
        if (result.hasErrors()) {
            return "vacancy.edit";
        } else {
            final IVacancy entity = fromDtoConverter.apply(formAccount);
            vacancyService.save(entity);
            return "redirect:/jobs";
        }
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id", required = true) final Integer id) {
        vacancyService.delete(id);
        return "redirect:/jobs";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewDetails(
            @PathVariable(name = "id", required = true) final Integer id) {
        final IVacancy dbAccount = vacancyService.get(id);
        final VacancyDTO dto = toDtoConverter.apply(dbAccount);
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("formVacancy", dto);
        hashMap.put("readonly", true);

        return new ModelAndView("vacancy.edit", hashMap);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(
            @PathVariable(name = "id", required = true) final Integer id) {
        final VacancyDTO dto = toDtoConverter.apply(vacancyService.get(id));

        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("formVacancy", dto);

        return new ModelAndView("vacancy.edit", hashMap);
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public ResponseEntity<VacancyDTO> getCountries(
            @RequestParam(name = "id", required = true) final Integer id) {
        final VacancyDTO dto = toDtoConverter.apply(vacancyService.get(id));

        return new ResponseEntity<VacancyDTO>(dto, HttpStatus.OK);
    }
    
}

package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.IVacancyService;
import com.itacademy.jd2.ml.linkedin.entity.table.IVacancy;
import com.itacademy.jd2.ml.linkedin.filter.VacancyFilter;
import com.itacademy.jd2.ml.linkedin.web.converter.fromDTO.VacancyFromDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.VacancyToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.dto.VacancyDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.grid.GridStateDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/findvacancy")
public class FindVacancyController extends AbstractController{

    private IVacancyService vacancyService;
    private VacancyFromDTOConverter fromDtoConverter;
    private VacancyToDTOConverter toDtoConverter;

    public FindVacancyController(IVacancyService vacancyService, VacancyFromDTOConverter fromDtoConverter, VacancyToDTOConverter toDtoConverter) {
        super();
        this.vacancyService = vacancyService;
        this.fromDtoConverter = fromDtoConverter;
        this.toDtoConverter = toDtoConverter;
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
        List<VacancyDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());
        gridState.setTotalCount(vacancyService.getCount(filter));

        final Map<String, Object> models = new HashMap<>();
        models.put("gridItems", dtos);
        return new ModelAndView("findVacancy.list", models);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewDetails(
            @PathVariable(name = "id", required = true) final Integer id) {
        final IVacancy dbAccount = vacancyService.get(id);
        final VacancyDTO dto = toDtoConverter.apply(dbAccount);
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("formVacancy", dto);
        hashMap.put("readonly", true);

        return new ModelAndView("findVacancy.form", hashMap);
    }

}

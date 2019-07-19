package com.itacademy.jd2.ml.linkedin.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.itacademy.jd2.ml.linkedin.IUserPortfolioService;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import com.itacademy.jd2.ml.linkedin.filter.UserPortfolioFilter;
import com.itacademy.jd2.ml.linkedin.web.converter.UserPortfolioFromDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.UserPortfolioToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.dto.UserPortfolioDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.grid.GridStateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class UserPortfolioController extends AbstractController {

    private IUserPortfolioService userPortfolioService;

    private UserPortfolioToDTOConverter toDtoConverter;

    private UserPortfolioFromDTOConverter fromDtoConverter;

    @Autowired
    public UserPortfolioController(IUserPortfolioService userPortfolioService, UserPortfolioToDTOConverter toDtoConverter, UserPortfolioFromDTOConverter fromDtoConverter) {
        super();
        this.userPortfolioService = userPortfolioService;
        this.toDtoConverter = toDtoConverter;
        this.fromDtoConverter = fromDtoConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(final HttpServletRequest req,
                              @RequestParam(name = "page", required = false) final Integer pageNumber,
                              @RequestParam(name = "sort", required = false) final String sortColumn) {

        final GridStateDTO gridState = getListDTO(req);
        gridState.setPage(pageNumber);
        gridState.setSort(sortColumn, "id");

        final UserPortfolioFilter filter = new UserPortfolioFilter();
        prepareFilter(gridState, filter);

        final List<IUserPortfolio> entities = userPortfolioService.find(filter);
        List<UserPortfolioDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());
        gridState.setTotalCount(userPortfolioService.getCount(filter));

        final Map<String, Object> models = new HashMap<>();
        models.put("gridItems", dtos);
        return new ModelAndView("user.list", models);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showForm() {
        final Map<String, Object> hashMap = new HashMap<>();
        final IUserPortfolio newEntity = userPortfolioService.createEntity();
        hashMap.put("formUser", toDtoConverter.apply(newEntity));

        return new ModelAndView("user.edit", hashMap);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("formUser") final UserPortfolioDTO formUser,
                       final BindingResult result) {
        if (result.hasErrors()) {
            return "user.edit";
        } else {
            final IUserPortfolio entity = fromDtoConverter.apply(formUser);
            userPortfolioService.save(entity);
            return "redirect:/user";
        }
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id", required = true) final Integer id) {
        userPortfolioService.delete(id);
        return "redirect:/user";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewDetails(
            @PathVariable(name = "id", required = true) final Integer id) {
        final IUserPortfolio dbModel = userPortfolioService.get(id);
        final UserPortfolioDTO dto = toDtoConverter.apply(dbModel);
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("formUser", dto);
        hashMap.put("readonly", true);

        return new ModelAndView("user.edit", hashMap);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(
            @PathVariable(name = "id", required = true) final Integer id) {
        final UserPortfolioDTO dto = toDtoConverter.apply(userPortfolioService.get(id));

        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("formUser", dto);

        return new ModelAndView("user.edit", hashMap);
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public ResponseEntity<UserPortfolioDTO> getCountries(
            @RequestParam(name = "id", required = true) final Integer id) {
        final UserPortfolioDTO dto = toDtoConverter.apply(userPortfolioService.get(id));

        return new ResponseEntity<UserPortfolioDTO>(dto, HttpStatus.OK);
    }

}
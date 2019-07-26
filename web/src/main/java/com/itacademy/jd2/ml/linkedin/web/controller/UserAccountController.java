package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.IUserAccountService;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.filter.UserAccountFilter;
import com.itacademy.jd2.ml.linkedin.web.converter.UserAccountFromDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.UserAccountToDTOConverter;
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
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/account")
public class UserAccountController extends AbstractController {
    
    private IUserAccountService userAccountService;
    private UserAccountFromDTOConverter fromDtoConverter;
    private UserAccountToDTOConverter toDtoConverter;

    @Autowired
    public UserAccountController(IUserAccountService userAccountService, UserAccountFromDTOConverter fromDtoConverter, UserAccountToDTOConverter toDtoConverter) {
        super();
        this.userAccountService = userAccountService;
        this.fromDtoConverter = fromDtoConverter;
        this.toDtoConverter = toDtoConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(final HttpServletRequest req,
                              @RequestParam(name = "page", required = false) final Integer pageNumber,
                              @RequestParam(name = "sort", required = false) final String sortColumn) {

        final GridStateDTO gridState = getListDTO(req);
        gridState.setPage(pageNumber);
        gridState.setSort(sortColumn, "id");

        final UserAccountFilter filter = new UserAccountFilter();
        prepareFilter(gridState, filter);

        final List<IUserAccount> entities = userAccountService.find(filter);
        List<UserAccountDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());
        gridState.setTotalCount(userAccountService.getCount(filter));

        final Map<String, Object> models = new HashMap<>();
        models.put("gridItems", dtos);
        return new ModelAndView("account.list", models);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showForm() {
        final Map<String, Object> hashMap = new HashMap<>();
        final IUserAccount newEntity = userAccountService.createEntity();
        hashMap.put("formAccount", toDtoConverter.apply(newEntity));

        return new ModelAndView("account.edit", hashMap);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("formAccount") final UserAccountDTO formAccount,
                       final BindingResult result) {
        if (result.hasErrors()) {
            return "account.edit";
        } else {
            final IUserAccount entity = fromDtoConverter.apply(formAccount);
            userAccountService.save(entity);
            return "redirect:/account";
        }
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id", required = true) final Integer id) {
        userAccountService.delete(id);
        return "redirect:/account";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewDetails(
            @PathVariable(name = "id", required = true) final Integer id) {
        final IUserAccount dbAccount = userAccountService.get(id);
        final UserAccountDTO dto = toDtoConverter.apply(dbAccount);
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("formAccount", dto);
        hashMap.put("readonly", true);

        return new ModelAndView("account.edit", hashMap);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(
            @PathVariable(name = "id", required = true) final Integer id) {
        final UserAccountDTO dto = toDtoConverter.apply(userAccountService.get(id));

        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("formAccount", dto);

        return new ModelAndView("account.edit", hashMap);
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public ResponseEntity<UserAccountDTO> getCountries(
            @RequestParam(name = "id", required = true) final Integer id) {
        final UserAccountDTO dto = toDtoConverter.apply(userAccountService.get(id));

        return new ResponseEntity<UserAccountDTO>(dto, HttpStatus.OK);
    }
    
}

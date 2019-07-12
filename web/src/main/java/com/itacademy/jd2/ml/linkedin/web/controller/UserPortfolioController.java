package com.itacademy.jd2.ml.linkedin.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.itacademy.jd2.ml.linkedin.IUserPortfolioService;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import com.itacademy.jd2.ml.linkedin.filter.UserPortfolioFilter;
import com.itacademy.jd2.ml.linkedin.web.converter.UserPortfolioToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.dto.UserPortfolioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class UserPortfolioController {

    private IUserPortfolioService userPortfolioService;

    private UserPortfolioToDTOConverter toDtoConverter;

    @Autowired
    public UserPortfolioController(IUserPortfolioService userPortfolioService, UserPortfolioToDTOConverter toDtoConverter) {
        super();
        this.userPortfolioService = userPortfolioService;
        this.toDtoConverter = toDtoConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(final HttpServletRequest req) {

        final UserPortfolioFilter filter = new UserPortfolioFilter();

        final List<IUserPortfolio> entities = userPortfolioService.find(filter);
        List<UserPortfolioDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());

        final Map<String, Object> models = new HashMap<>();
        models.put("gridItems", dtos);
        return new ModelAndView("user.list", models);
    }

}
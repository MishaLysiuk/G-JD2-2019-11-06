package com.itacademy.jd2.ml.linkedin.web.converter;

import com.itacademy.jd2.ml.linkedin.IUserPortfolioService;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import com.itacademy.jd2.ml.linkedin.web.dto.UserPortfolioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserPortfolioFromDTOConverter implements Function<UserPortfolioDTO, IUserPortfolio> {

    @Autowired
    private IUserPortfolioService userPortfolioService;

    @Override
    public IUserPortfolio apply(final UserPortfolioDTO dto) {
        final IUserPortfolio entity = userPortfolioService.createEntity();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        return entity;
    }
}
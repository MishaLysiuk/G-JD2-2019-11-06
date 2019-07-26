package com.itacademy.jd2.ml.linkedin.web.converter;

import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import com.itacademy.jd2.ml.linkedin.web.dto.UserPortfolioDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserPortfolioToDTOConverter implements Function<IUserPortfolio, UserPortfolioDTO> {


    @Override
    public UserPortfolioDTO apply(IUserPortfolio entity) {
        final UserPortfolioDTO dto = new UserPortfolioDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setCreated(entity.getCreated());
        dto.setUpdated(entity.getUpdated());
        return dto;
    }
}
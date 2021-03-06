package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.ICompanyService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.CompanyToDTOConverter;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "autocomplete/")
public class AutocompleteController extends AbstractController {

    private ICompanyService companyService;
    private CompanyToDTOConverter toDTOConverter;

    @Autowired
    public AutocompleteController(ICompanyService companyService, CompanyToDTOConverter toDTOConverter) {
        this.companyService = companyService;
        this.toDTOConverter = toDTOConverter;
    }

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Integer>> getCompanies(@RequestParam(name = "name") String name) {
        List<ICompany> companies = companyService.findByName(name);


        Map<String, Integer> map = new HashedMap();
        for (ICompany c : companies) {
            map.put(c.getName(), c.getId());

        }


        // List<CompanyDTO> companiesDTO = companies.stream().map(toDTOConverter).collect(Collectors.toList());
        return new ResponseEntity<Map<String, Integer>>(map, HttpStatus.OK);
    }

}

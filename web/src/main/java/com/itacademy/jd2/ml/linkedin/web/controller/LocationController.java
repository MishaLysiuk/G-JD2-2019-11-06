package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.ICityService;
import com.itacademy.jd2.ml.linkedin.ICountryService;
import com.itacademy.jd2.ml.linkedin.IRegionService;
import com.itacademy.jd2.ml.linkedin.impl.AbstractDaoImpl;
import com.itacademy.jd2.ml.linkedin.web.dto.CityDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.CountryDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.RegionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/location")
public class LocationController {
/*
    private IRegionService regionService;
    private ICountryService countryService;
    private ICityService cityService;

    @Autowired
    public LocationController(IRegionService regionService, ICountryService countryService, ICityService cityService) {
        this.regionService = regionService;
        this.countryService = countryService;
        this.cityService = cityService;
    }

    @RequestMapping(value = "/regions", method = RequestMethod.GET)
    public ResponseEntity<List<RegionDTO>> getRegions() {
        final List<RegionDTO> regions = regionService.getAll();
        if (countryId.equals(1)) {
            regions.add(new RegionDTO(1, "Гродненская область"));
            regions.add(new RegionDTO(2, "Минская область"));
            regions.add(new RegionDTO(3, "Витебская область"));
            regions.add(new RegionDTO(4, "Гомельская область"));
            regions.add(new RegionDTO(5, "Могилевская область"));
            regions.add(new RegionDTO(6, "Брестская область"));
        } else if (countryId.equals(2)) {
            regions.add(new RegionDTO(7, "russian region 1"));
            regions.add(new RegionDTO(8, "russian region 2"));
            regions.add(new RegionDTO(9, "russian region 3"));
        } else if (countryId.equals(3)) {
            regions.add(new RegionDTO(10, "france region 1"));
            regions.add(new RegionDTO(11, "france region 1"));
        }
        return new ResponseEntity<List<RegionDTO>>(regions, HttpStatus.OK);
    }

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public ResponseEntity<List<CountryDTO>> getCountries(
            @RequestParam(name = "regionId", required = true) final Integer regionId) {
        final List<CountryDTO> countries = cityService.findCountryByRegionId(regionId);
        countries.add(new CountryDTO(1, "Belarus"));
        countries.add(new CountryDTO(2, "Russia"));
        countries.add(new CountryDTO(3, "France"));
        return new ResponseEntity<List<CountryDTO>>(countries, HttpStatus.OK);
    }


    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public ResponseEntity<List<CityDTO>> getCities(
            @RequestParam(name = "countryId", required = true) final Integer countryId) {
        final List<CityDTO> cities = cityService.findCityByCountryId(countryId);

        return new ResponseEntity<List<CityDTO>>(cities, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object save(@Valid @ModelAttribute("addressForm") final AddressDTO formModel, final BindingResult result) {
        return "redirect:/location";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPage() {
        return new ModelAndView("ajax-samples", "addressForm", new AddressDTO());
    }*/

}

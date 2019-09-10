package com.itacademy.jd2.ml.linkedin.web.controller;

import com.itacademy.jd2.ml.linkedin.ICityService;
import com.itacademy.jd2.ml.linkedin.ICountryService;
import com.itacademy.jd2.ml.linkedin.IRegionService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;
import com.itacademy.jd2.ml.linkedin.entity.table.IRegion;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.CityToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.CountryToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.converter.toDTO.RegionToDTOConverter;
import com.itacademy.jd2.ml.linkedin.web.dto.CityDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.CountryDTO;
import com.itacademy.jd2.ml.linkedin.web.dto.RegionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/location")
public class LocationController {
    private IRegionService regionService;
    private ICountryService countryService;
    private ICityService cityService;

    private CityToDTOConverter cityToDTOConverter;
    private CountryToDTOConverter countryToDTOConverter;
    private RegionToDTOConverter regionToDTOConverter;

    @Autowired
    public LocationController(IRegionService regionService, ICountryService countryService, ICityService cityService, CityToDTOConverter cityToDTOConverter, CountryToDTOConverter countryToDTOConverter, RegionToDTOConverter regionToDTOConverter) {
        this.regionService = regionService;
        this.countryService = countryService;
        this.cityService = cityService;
        this.cityToDTOConverter = cityToDTOConverter;
        this.countryToDTOConverter = countryToDTOConverter;
        this.regionToDTOConverter = regionToDTOConverter;
    }

    @RequestMapping(value = "/regions", method = RequestMethod.GET)
    public ResponseEntity<List<RegionDTO>> getRegions() {
        final List<IRegion> regions = regionService.getAll();
        List<RegionDTO> regionsDTO = regions.stream().map(regionToDTOConverter).collect(Collectors.toList());
        return new ResponseEntity<List<RegionDTO>>(regionsDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public ResponseEntity<List<CountryDTO>> getCountries(
            @RequestParam(name = "regionId", required = true) final Integer regionId) {
        final List<ICountry> countries = cityService.findCountryByRegionId(regionId);
        List<CountryDTO> countriesDTO = countries.stream().map(countryToDTOConverter).collect(Collectors.toList());
        return new ResponseEntity<List<CountryDTO>>(countriesDTO, HttpStatus.OK);
    }


    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public ResponseEntity<List<CityDTO>> getCities(
            @RequestParam(name = "countryId", required = true) final Integer countryId) {
        final List<ICity> cities = cityService.findCityByCountryId(countryId);
        List<CityDTO> citiesDTO = cities.stream().map(cityToDTOConverter).collect(Collectors.toList());

        return new ResponseEntity<List<CityDTO>>(citiesDTO, HttpStatus.OK);
    }

    /*private Map<Integer, String> loadCities(Integer countryId) {

        final Map<Integer, String> cities = cityService.findCityByCountryId(countryId).stream()
                .collect(Collectors.toMap(ICity::getId, ICity::getName));

        return cities;
    }

    private Map<Integer, String> loadCountries(Integer regionId) {

        final Map<Integer, String> countries = cityService.findCountryByRegionId(regionId).stream()
                .collect(Collectors.toMap(ICountry::getId, ICountry::getName));

        return countries;
    }

    private Map<Integer, String> loadRegions() {

        final Map<Integer, String> regions = regionService.getAll().stream()
                .collect(Collectors.toMap(IRegion::getId, IRegion::getName));

        return regions;
    }*/

}

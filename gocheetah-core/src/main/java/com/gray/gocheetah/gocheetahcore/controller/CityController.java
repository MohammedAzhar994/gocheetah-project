package com.gray.gocheetah.gocheetahcore.controller;

import com.gray.gocheetah.gocheetahcore.model.City;
import com.gray.gocheetah.gocheetahcore.model.dto.CityDTO;
import com.gray.gocheetah.gocheetahcore.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 16-Sep-22
 * Time: 5:59 PM
 * gocheetah-core
 */
@RestController
@CrossOrigin
public class CityController {

    CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/city")
    public ResponseEntity<List<CityDTO>> getAllCities() {
        Optional<List<City>> allCities = cityService.getAllCities();
        if (allCities.isPresent()) {
            List<CityDTO> cityDTOS = allCities.get().stream().map(City::toDto).collect(Collectors.toList());
            return ResponseEntity.ok(cityDTOS);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/city")
    public ResponseEntity<CityDTO> setCity(@RequestBody @Validated CityDTO cityDTO) {
        Optional<City> city = cityService.saveCity(cityDTO.toEntity());
        return ResponseEntity.ok(city.get().toDto());
    }

}

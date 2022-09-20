package com.gray.gocheetah.gocheetahcore.controller;

import com.gray.gocheetah.gocheetahcore.model.Admin;
import com.gray.gocheetah.gocheetahcore.model.City;
import com.gray.gocheetah.gocheetahcore.model.Driver;
import com.gray.gocheetah.gocheetahcore.model.dto.AdminDTO;
import com.gray.gocheetah.gocheetahcore.model.dto.DriverDTO;
import com.gray.gocheetah.gocheetahcore.service.CityService;
import com.gray.gocheetah.gocheetahcore.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 17-Sep-22
 * Time: 11:06 PM
 * gocheetah-core
 */
@RestController
@CrossOrigin
public class DriverController {

    DriverService driverService;

    CityService cityService;

    @Autowired
    public DriverController(DriverService driverService, CityService cityService) {
        this.driverService = driverService;
        this.cityService = cityService;
    }

    @PostMapping("/driver")
    public ResponseEntity<DriverDTO> setDriver(
            @RequestBody @Validated DriverDTO driverDTO){
        driverDTO.setCreatedDate(Instant.now());
        Optional<City> cityByID = cityService.getCityByID(driverDTO.getCityId());
        Driver driver = driverDTO.toEntity();
        driver.setAvailability(true);
        driver.setStatus("Active");
        driver.setCity(cityByID.get());
        Optional<Driver> driverOptional = driverService.saveDriver(driver);
        return driverOptional.map(value -> ResponseEntity.status(HttpStatus.ACCEPTED).body(value.toDto())).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}

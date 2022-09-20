package com.gray.gocheetah.gocheetahcore.controller;

import com.gray.gocheetah.gocheetahcore.model.City;
import com.gray.gocheetah.gocheetahcore.model.IntercityPrice;
import com.gray.gocheetah.gocheetahcore.model.dto.IntercityPriceDTO;
import com.gray.gocheetah.gocheetahcore.service.CityService;
import com.gray.gocheetah.gocheetahcore.service.IntercityPriceService;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 16-Sep-22
 * Time: 5:58 PM
 * gocheetah-core
 */
@RestController
@CrossOrigin
public class InterCityPriceController {

    IntercityPriceService intercityPriceService;

    CityService cityService;

    @Autowired
    public InterCityPriceController(IntercityPriceService intercityPriceService, CityService cityService) {
        this.intercityPriceService = intercityPriceService;
        this.cityService = cityService;
    }

    @GetMapping("/price")
    public ResponseEntity<List<IntercityPriceDTO>> getAllprice() {
        List<IntercityPriceDTO> allPrices = intercityPriceService.getAllPrices().stream().map(IntercityPrice::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(allPrices);
    }
    @PostMapping("/price")
    public ResponseEntity<IntercityPriceDTO> savePrice(
            @RequestParam String name,
            @RequestParam String cost,
            @RequestParam String city1,
            @RequestParam String city2) {
        Optional<City> depart = cityService.getCityByID(Long.valueOf(city1));
        Optional<City> arrive = cityService.getCityByID(Long.valueOf(city2));
        IntercityPrice price = new IntercityPrice();
        price.setDepartingCity(depart.get());
        price.setArrivingCity(arrive.get());
        price.setName(name);
        price.setCreatedDate(Instant.now());
        price.setCost(Double.parseDouble(cost));
        Optional<IntercityPrice> intercityPrice = intercityPriceService.savePrice(price);
        return ResponseEntity.ok(intercityPrice.get().toDto());
    }

    @GetMapping("/price/{id}")
    public ResponseEntity<IntercityPriceDTO> getPriceById(
            @Validated
            @PathVariable Long id
    ) {
        Optional<IntercityPrice> priceByID = intercityPriceService.getPriceByID(id);
        return priceByID.map(price -> ResponseEntity.ok(price.toDto())).orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
